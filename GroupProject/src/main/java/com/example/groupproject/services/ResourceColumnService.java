package com.example.groupproject.services;

import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.entities.Resource;
import com.example.groupproject.entities.ResourceColumn;

import java.util.List;

public interface ResourceColumnService {
    //CRUD
    //Create
    public boolean create(Resource resource, ProjectDetail projectDetail, ResourceColumn resourceColumn);
    //Read
    public ResourceColumn get(Integer resourceColumnId);
    public ResourceColumn get(Resource resource, ProjectDetail projectDetail);
    public List<ResourceColumn> get(ProjectDetail projectDetail);
    //Update
    public boolean update(ResourceColumn resourceColumn);
    //Delete
    public boolean delete(ResourceColumn resourceColumn);
}
