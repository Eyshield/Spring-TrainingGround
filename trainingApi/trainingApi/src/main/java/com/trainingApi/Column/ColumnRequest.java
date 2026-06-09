package com.trainingApi.Column;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class ColumnRequest {
    private UUID id;
    @NotBlank(message = "The title is required")
    private String title;
    @NotBlank(message = "The position is required")
    private String position;
    @NotBlank(message = "The project is required")
    private UUID projectId;
}
