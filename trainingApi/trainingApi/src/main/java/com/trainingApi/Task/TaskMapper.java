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
    public  Task toTask(TaskRequest taskRequest){
        return Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .priority(taskRequest.getPriority())
                .build();
    }
}
