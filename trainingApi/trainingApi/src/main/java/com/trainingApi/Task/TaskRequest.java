package com.trainingApi.Task;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TaskRequest {
    private UUID id;
    @NotBlank(message = "The title is required")
    private String title;
    @NotBlank(message = "The description is required")
    private String description;
    @NotBlank(message = "The priority is required")
    private String priority;
    @NotBlank(message = "The user is required")
    private UUID userId;
    @NotBlank(message = "The project is required")
    private UUID projectId;
    @NotBlank(message = "The column is required")
    private  UUID columnId;
}
