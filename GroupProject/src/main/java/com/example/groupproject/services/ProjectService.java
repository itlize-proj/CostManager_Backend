package com.example.groupproject.services;

import com.example.groupproject.entities.Project;
import com.example.groupproject.repositories.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    // GET
    // get all project
    public List<Project> getAll () {
        return projectDAO.findAll();
    }

    // get project by project ID
    public Project getProjectById (Integer id) {
        return projectDAO.findById(id).get();
    }

    // get project by project Name
    public Project getProjectByName(String name) {
        List<Project> list = projectDAO.findAll();
        list.stream().filter(p ->(p.getProjectName().equals(name)));
        Project project = list.get(0);
        return project;
    }

    // UPDATE
    public void update(Project project) {
        projectDAO.save(project);
    }
    // CREATE
    public void create(Project project) {
        projectDAO.save(project);
    }

    // DELETE
    // delete project by ID
    public void deleteProjectById(int id) {
        projectDAO.deleteById(id);
    }
    // delete project by name
    public void deleteProjectByName(String name) {
        projectDAO.delete(getProjectByName(name));
    }

}
