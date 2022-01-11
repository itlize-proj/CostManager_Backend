package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ResourceToProject;
import com.example.groupproject.entities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceToProjectDAO extends JpaRepository<ResourceToProject, Integer> {

    public List<ResourceToProject> findByProjectAndResource(Project project, Resources resources);
    public List<ResourceToProject> findByProject(Project project);
}
