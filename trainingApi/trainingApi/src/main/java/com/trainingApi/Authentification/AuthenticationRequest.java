package com.trainingApi.Authentification;

import com.trainingApi.Common.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationRequest {
    @NotBlank(message = "The email is required")
    private String email;
    @NotBlank(message = "The password is required")
    private String password;
    private String username;
    private Role role;
}
