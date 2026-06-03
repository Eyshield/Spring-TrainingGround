package com.trainingApi.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class TaskResponse {
    private UUID id;
    private String title;
    private String description;
    private String priority;
    private String username;
}
