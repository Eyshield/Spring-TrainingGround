package com.trainingApi.Project;

import com.trainingApi.Common.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectMapper {
    public ProjectResponse toProjectResponse(Project project){
        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .created_At(project.getCreated_At())
                .updated_At(project.getUpdated_At())
                .creatorName(project.getUser().getUsername())
                .build();
    }

    public Project toProject(ProjectRequest projectRequest){
        return Project.builder()
                .name(projectRequest.getName())
                .description(projectRequest.getDescription())
                .created_At(LocalDate.now())
                .build();
    }


    public PageResponse<ProjectResponse> toPageResponse(Page<Project> projects){
        List<ProjectResponse> projectResponseList =new ArrayList<>();
        for (Project project:projects.getContent()){
            projectResponseList.add(toProjectResponse(project));
        }
        return new PageResponse<ProjectResponse>(
                projectResponseList,
        projects.getNumber(),
                projects.getSize(),
                projects.getTotalElements(),
                projects.getTotalPages(),
                projects.isFirst(),
                projects.isLast()
                );
    }
}
