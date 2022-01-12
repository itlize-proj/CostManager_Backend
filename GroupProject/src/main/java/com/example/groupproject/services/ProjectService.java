package com.example.groupproject.services;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;

import java.util.List;

public interface ProjectService {
    List<Project> findByUser(User user);

    void createByUser(User user, Project project);

    void deleteByUser(User user, Integer projectId);

     List<Project> getAll();

     List<Project> getAllByUser(User user);

     Project getProjectByProjectName(String name);
}
