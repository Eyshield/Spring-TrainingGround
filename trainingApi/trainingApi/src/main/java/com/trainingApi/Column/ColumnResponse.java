package com.trainingApi.Column;

import com.trainingApi.Task.TaskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class ColumnResponse {
    private UUID id;
    private String title;
    private String position;
    private List<TaskResponse> taskResponses;
}
