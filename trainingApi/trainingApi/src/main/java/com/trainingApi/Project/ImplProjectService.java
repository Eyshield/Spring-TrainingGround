package com.trainingApi.Project;

import com.trainingApi.Common.PageResponse;
import com.trainingApi.ExceptionHandler.ResourceNotFoundException;
import com.trainingApi.User.User;
import com.trainingApi.User.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImplProjectService implements ProjectService {
    private final ProjectRepo projectRepo;
    private final ProjectMapper projectMapper;
    private final UserRepo userRepo;
    @Override
    public ProjectResponse addProject(ProjectRequest projectRequest) {
        User user = userRepo.findById(projectRequest.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        Project project=projectMapper.toProject(projectRequest);
        project.setUser(user);
        return projectMapper.toProjectResponse(projectRepo.save(project));
    }

    @Override
    public ProjectResponse getProject(UUID id) {
        return projectMapper.toProjectResponse(findProjectById(id));
    }

    @Override
    public ProjectResponse updateProject(UUID id, ProjectRequest projectRequest) {
        Project project = findProjectById(id);
        project.setUpdated_At(LocalDate.now());
        project.setName(projectRequest.getName());
        project.setDescription(project.getDescription());
        return projectMapper.toProjectResponse(projectRepo.save(project));
    }

    @Override
    public void deleteProject(UUID id) {
   projectRepo.deleteById(id);
    }

    @Override
    public PageResponse<ProjectResponse> getAllProject(Pageable pageable) {
        return projectMapper.toPageResponse( projectRepo.findAll(pageable));
    }

    @Override
    public PageResponse<ProjectResponse> searchProject(Pageable pageable,String name) {
        return projectMapper.toPageResponse(projectRepo.findByNameContainingIgnoreCase(pageable, name));
    }
    private Project findProjectById(UUID id){
        return projectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Project not found"));
    }
}
