package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.ProjectDetails;
import com.example.groupproject.repositories.ProjectDAO;
import com.example.groupproject.repositories.ProjectDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailsServiceImp {
    @Autowired
    private ProjectDetailsDAO projectDetailsDAO;
    @Autowired
    private ProjectDAO projectDAO;

    // GET
    // get project details by detail id
    public ProjectDetails getById(int id) {
        return projectDetailsDAO.findById(id).get();
    }

    // get project details by detail id
    public List<ProjectDetails> getByProjectId(int projectId) {
        //List<ProjectDetails> list = projectDAO.
        List<ProjectDetails> list = projectDetailsDAO.findAll();
        //list.stream().filter(r -> (r.get().equals()));


        return list;
    }


    public ProjectDetails getBy(int id) {
        return projectDetailsDAO.findById(id).get();
    }
    // get resource by Name
    public ProjectDetails getByName(String name) {
        List<ProjectDetails> list = projectDetailsDAO.findAll();
        list.stream().filter(r -> (r.getDetailName().equals(name)));
        ProjectDetails resources = list.get(0);
        return resources;
    }
    // get by Resource Code
    /*public Resources getByCode (String code) {
        List<Resources> list = resourcesDAO.findAll();
        list.stream().filter(r -> (r.getResourceName().equals(code)));
        Resources resources = list.get(0);
        return resources;
    }*/
    // Update
    public void update(ProjectDetails projectDetails) {
        projectDetailsDAO.save(projectDetails);
    }
    // Add
    public void addResources(ProjectDetails projectDetails) {
        projectDetailsDAO.save(projectDetails);
    }
    // Can't have Delete method  !!

}
