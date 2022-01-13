package com.example.groupproject.services;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetail;

import java.util.List;

public interface ProjectDetailService {
    //CRUD
    //Create
    public boolean create(ProjectDetail projectDetail, Project project);
    //Read
    public ProjectDetail get(Integer detailId);
    public List<ProjectDetail> get(Project project);
    //Update
    public boolean update(ProjectDetail projectDetail);
    //Delete
    public boolean delete(ProjectDetail projectDetail);
}
