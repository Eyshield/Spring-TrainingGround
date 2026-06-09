package com.trainingApi.Task;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping("/add")
    public ResponseEntity<TaskResponse> addTask(@RequestBody @Valid TaskRequest taskRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(taskRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity <TaskResponse>updateTask(@PathVariable UUID id, @RequestBody @Valid TaskRequest taskRequest){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id,taskRequest));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
