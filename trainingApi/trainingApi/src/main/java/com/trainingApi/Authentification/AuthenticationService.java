package com.trainingApi.Authentification;

import com.trainingApi.User.User;
import com.trainingApi.User.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse signUp(AuthenticationRequest request){
        User user= new User();
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        String token= jwtService.generateToken(user);
        userRepo.save(user);
        return new AuthResponse(token);
    }
    public AuthResponse Login(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user = userRepo.findByEmail(request.getEmail()).orElseThrow(()->new BadCredentialsException("Email or password incorrect"));
        String token= jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
