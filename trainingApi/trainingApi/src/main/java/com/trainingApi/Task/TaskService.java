package com.trainingApi.Task;

import java.util.UUID;

public interface TaskService {
    TaskResponse addTask(TaskRequest taskRequest);
    TaskResponse updateTask(UUID id,TaskRequest taskRequest);
    void deleteTask(UUID id);
}
