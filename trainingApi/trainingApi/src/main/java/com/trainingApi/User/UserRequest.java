package com.trainingApi.User;

import com.trainingApi.Common.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRequest {

    private UUID id;
    private String email;
    private String password;
    private String username;
    private Role role;
}
