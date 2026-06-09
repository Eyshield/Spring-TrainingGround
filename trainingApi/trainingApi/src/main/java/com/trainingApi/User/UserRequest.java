package com.trainingApi.User;

import com.trainingApi.Common.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRequest {

    private UUID id;
    @NotBlank(message ="The email is required")
    private String email;
    @NotBlank(message ="The password is required")
    private String password;
    @NotBlank(message ="The username is required")
    private String username;
    @NotBlank(message ="The role is required")
    private Role role;
}
