package com.trainingApi.Security;

import com.trainingApi.Authentification.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@AllArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private UserDetailsService userDetailsService;
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String header = request.getHeader("Authorization");
      if (header == null && !header.startsWith("Bearer ")){
          filterChain.doFilter(request,response);
          return;
      }
      try {
          String token=header.substring(7);
          String email = jwtService.extractUserName(token);
          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
          if (email != null && authentication == null) {
              UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);

              if (jwtService.isTokenValid(token, userDetails)) {
                  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                          userDetails,
                          null,
                          userDetails.getAuthorities()
                  );

                  authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContextHolder.getContext().setAuthentication(authToken);
              }
          }
          filterChain.doFilter(request,response);



      }catch (Exception exception){
          handlerExceptionResolver.resolveException(request, response, null, exception);
      }
    }
}
