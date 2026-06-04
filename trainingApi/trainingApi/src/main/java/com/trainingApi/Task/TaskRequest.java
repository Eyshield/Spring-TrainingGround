package com.trainingApi.Task;

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
    private String title;
    private String description;
    private String priority;
    private UUID userId;
    private UUID projectId;
    private  UUID columnId;
}
