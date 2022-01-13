package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ResourceToProject;
import com.example.groupproject.entities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceToProjectDAO extends JpaRepository<ResourceToProject, Integer> {
    ResourceToProject findByProjectAndResources(Project project, Resources resources);
    Optional<List<ResourceToProject>> findByProject(Project project);
    void deleteByResourcesAndProject(Project project, Resources resources);
}
