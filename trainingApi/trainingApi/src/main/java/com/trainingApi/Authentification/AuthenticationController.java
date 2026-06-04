package com.trainingApi.Authentification;

import com.trainingApi.User.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@AllArgsConstructor
public class AuthenticationController {
    private  AuthenticationService authentificationService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> Register(@RequestBody AuthenticationRequest user){

        AuthResponse authResponse = authentificationService.signUp(user);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthenticationRequest user){
        AuthResponse authResponse = authentificationService.Login(user);
        return ResponseEntity.ok(authResponse);
    }
}
