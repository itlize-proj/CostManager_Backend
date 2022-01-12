package com.example.groupproject.services;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetails;

import java.util.List;

public interface ProjectDetailsService {
    //CRUD
    //Create
    public boolean create(ProjectDetails projectDetails, Project project);
    //Read
    public ProjectDetails get(Integer detailId);
    public List<ProjectDetails> get(Project project);
    //Update
    public boolean update(ProjectDetails projectDetails);
    //Delete
    public boolean delete(ProjectDetails projectDetails);
}
