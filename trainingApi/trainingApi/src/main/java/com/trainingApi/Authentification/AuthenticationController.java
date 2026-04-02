package com.trainingApi.Authentification;

import com.trainingApi.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {
    private  AuthenticationService authentificationService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> Register(@RequestBody User user){

        AuthResponse authResponse = authentificationService.signUp(user);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User user){
        AuthResponse authResponse = authentificationService.Login(user);
        return ResponseEntity.ok(authResponse);
    }
}
