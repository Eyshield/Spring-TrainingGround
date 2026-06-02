package com.trainingApi.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProjectRepo extends JpaRepository<Project, UUID> {
    Page<Project>findByNameContainingIgnoreCase(Pageable pageable,String name);
}
