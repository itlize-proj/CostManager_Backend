package com.example.groupproject.services;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ResourceToProject;
import com.example.groupproject.entities.Resources;

import java.util.List;

public interface ResourceToProjectService {
    //CRUD
    //Create
    public boolean create(Resources resource, Project project, ResourceToProject resourceToProject);
    //Read
    public ResourceToProject get(Integer resourceToProjectId);
    public ResourceToProject get(Resources resources, Project project);
    public List<ResourceToProject> get(Project project);
    //Update
    public boolean update(ResourceToProject resourceToProject);
    //Delete
    public boolean delete(ResourceToProject resourceToProject);
}
