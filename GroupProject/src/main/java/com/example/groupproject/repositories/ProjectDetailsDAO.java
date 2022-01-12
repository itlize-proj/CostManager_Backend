package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDetailsDAO extends JpaRepository<ProjectDetails, Integer> {
    public List<ProjectDetails> findProjectDetailsByDetailId(int detailId);
    public List<ProjectDetails> findProjectDetailsByProject(Project project);
}
