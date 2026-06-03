package com.trainingApi.Task;

import org.springframework.stereotype.Service;

@Service
public class TaskMapper {
    public TaskResponse toTaskResponse(Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority())
                .username(task.getUser().getUsername())
                .build();
    }
}
