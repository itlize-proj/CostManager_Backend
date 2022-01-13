package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.Resource;
import com.example.groupproject.entities.ResourceToProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceToProjectRepository extends JpaRepository<ResourceToProject, Integer> {
    ResourceToProject findByProjectAndResource(Project project, Resource resource);
    Optional<List<ResourceToProject>> findByProject(Project project);
    void deleteByResourceAndProject(Project project, Resource resource);
}
