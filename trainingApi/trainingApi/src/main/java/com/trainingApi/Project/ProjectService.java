package com.trainingApi.Project;

import com.trainingApi.Common.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProjectService {
    ProjectResponse addProject(ProjectRequest projectRequest);
    ProjectResponse getProject(UUID id);
    ProjectResponse updateProject(UUID id,ProjectRequest projectRequest);
    void deleteProject(UUID id);
    PageResponse<ProjectResponse> getAllProject(Pageable pageable);
    PageResponse<ProjectResponse> searchProject(Pageable pageable,String name);
}
