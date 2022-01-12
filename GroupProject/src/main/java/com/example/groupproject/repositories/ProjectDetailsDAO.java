package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectDetailsDAO extends JpaRepository<ProjectDetails, Integer> {
    Optional<ProjectDetails> findProjectDetailsByDetailId(int detailId);
    Optional<List<ProjectDetails>> findProjectDetailsByProject(Project project);
}
