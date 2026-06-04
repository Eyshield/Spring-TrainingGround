package com.trainingApi.Authentification;

import com.trainingApi.Common.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationRequest {
    private String email;
    private String password;
    private String username;
    private Role role;
}
