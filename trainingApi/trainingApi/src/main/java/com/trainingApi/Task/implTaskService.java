package com.trainingApi.Task;

import com.trainingApi.Column.Column;
import com.trainingApi.Column.ColumnRepo;
import com.trainingApi.ExceptionHandler.ResourceNotFoundException;
import com.trainingApi.Project.Project;
import com.trainingApi.Project.ProjectRepo;
import com.trainingApi.User.User;
import com.trainingApi.User.UserRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class implTaskService implements TaskService {
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;
    private final ProjectRepo projectRepo;
    private final UserRepo userRepo;
    private final ColumnRepo columnRepo;


    @Override
    public TaskResponse addTask(TaskRequest taskRequest) {
        Task task = taskMapper.toTask(taskRequest);
        User user = findUserById(taskRequest.getUserId());
        Project project= findProjectById(taskRequest.getProjectId());
        Column column = findColumnById(taskRequest.getColumnId());
        task.setUser(user);
        task.setColumn(column);
        task.setProject(project);
        return taskMapper.toTaskResponse(taskRepo.save(task));
    }

    @Override
    public TaskResponse updateTask(UUID id, TaskRequest taskRequest) {
        Task task = findTaskById(id);
        User user = findUserById(taskRequest.getUserId());
        Project project= findProjectById(taskRequest.getProjectId());
        Column column = findColumnById(taskRequest.getColumnId());
        task.setPriority(taskRequest.getPriority());
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setUser(user);
        task.setColumn(column);
        task.setProject(project);
        return taskMapper.toTaskResponse(taskRepo.save(task));
    }

    @Override
    public void deleteTask(UUID id) {
      taskRepo.deleteById(id);
    }
    private Task findTaskById(UUID id){
    return taskRepo.findById(id).orElseThrow();
    }

    private User findUserById(UUID userId){
        return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
    }
    private Project findProjectById(UUID projectId){
        return projectRepo.findById(projectId).orElseThrow(()-> new ResourceNotFoundException("Project not found"));
    }
    private Column findColumnById(UUID columnId){
        return columnRepo.findById(columnId).orElseThrow(()-> new ResourceNotFoundException("Column not found"));
    }
}
