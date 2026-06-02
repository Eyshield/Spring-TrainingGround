package com.trainingApi.Project;

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
    private String name;
    private String description;
    private LocalDate created_At;
    private LocalDate updated_At;
    private UUID userId;
}
