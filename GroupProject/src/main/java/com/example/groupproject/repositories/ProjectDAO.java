package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Integer> {
    Optional<Project> findByProjectId(int ProjectId);
    Optional<List<Project>> findAllByUser(User user);
    Optional<Project> findProjectByProjectName(String projectName);
    List<Project> findAll();
}
