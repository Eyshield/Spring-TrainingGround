package com.trainingApi.Authentification;

import com.trainingApi.User.User;
import com.trainingApi.User.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
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

    public AuthResponse signUp(User request){
        User user= new User();
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        String token= jwtService.generateToken(user);
        userRepo.save(user);
        return new AuthResponse(token);
    }
    public AuthResponse Login(User request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        User user = userRepo.findByEmail(request.getUsername()).orElseThrow();
        String token= jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
