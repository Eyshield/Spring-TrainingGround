package com.trainingApi.Project;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProjectRequest {
    private UUID id;
    @NotBlank(message = "Project name ies required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    private LocalDate created_At;
    private LocalDate updated_At;
    @NotBlank(message = "The user that creted the project is required")
    private UUID userId;
}
