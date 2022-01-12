package com.example.groupproject.services;

import com.example.groupproject.entities.ProjectDetails;
import com.example.groupproject.entities.ResourceColumn;
import com.example.groupproject.entities.Resources;

import java.util.List;

public interface ResourceColumnService {
    //CRUD
    //Create
    public boolean create(Resources resource, ProjectDetails projectDetails, ResourceColumn resourceColumn);
    //Read
    public ResourceColumn get(Integer resourceColumnId);
    public ResourceColumn get(Resources resources, ProjectDetails projectDetails);
    public List<ResourceColumn> get(ProjectDetails projectDetails);
    //Update
    public boolean update(ResourceColumn resourceColumn);
    //Delete
    public boolean delete(ResourceColumn resourceColumn);
}
