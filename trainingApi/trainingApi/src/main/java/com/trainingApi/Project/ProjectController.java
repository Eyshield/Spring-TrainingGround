package com.trainingApi.Project;

import com.trainingApi.Common.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;
    @PostMapping("/add")
    public ResponseEntity<ProjectResponse> addProject(@RequestBody ProjectRequest projectRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addProject(projectRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse>getProject(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getProject(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProjectResponse>updateProject(@PathVariable UUID id, @RequestBody ProjectRequest projectRequest){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.updateProject(id,projectRequest));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteProject(@PathVariable UUID id){
        projectService.deleteProject(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/all")
    public ResponseEntity<PageResponse<ProjectResponse>> getAllProject(@PageableDefault(page = 0, size=10) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getAllProject(pageable));
    }
    @GetMapping("/search")
    public ResponseEntity<PageResponse<ProjectResponse>>searchProject(@PageableDefault(page = 0,size = 10)Pageable pageable, @RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.searchProject(pageable,name));
    }
}
