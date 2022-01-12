package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetails;
import com.example.groupproject.repositories.ProjectDAO;
import com.example.groupproject.repositories.ProjectDetailsDAO;
import com.example.groupproject.services.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsServiceImp implements ProjectDetailsService {
    @Autowired
    private ProjectDetailsDAO projectDetailsDAO;

    @Override
    public boolean create(ProjectDetails projectDetails, Project project) {
        // check if exists
        if(get(projectDetails.getDetailId()) == null)
            return false;
        try {
            projectDetails.setProject(project);
            projectDetailsDAO.save(projectDetails);
            return true;
        } catch(Exception ex) {
            return false;
        }

    }

    @Override
    public ProjectDetails get(Integer detailId) {
        Optional<ProjectDetails> projectDetails = projectDetailsDAO.findProjectDetailsByDetailId(detailId);
        return projectDetails.isPresent()?projectDetails.get():null;
    }

    @Override
    public List<ProjectDetails> get(Project project) {
        Optional<List<ProjectDetails>> projectDetails = projectDetailsDAO.findProjectDetailsByProject(project);
        return projectDetails.isPresent()?projectDetails.get():null;
    }

    // Update
    @Override
    public boolean update(ProjectDetails projectDetails) {
        if(get(projectDetails.getDetailId()) == null) {
            projectDetailsDAO.save(projectDetails);
            return true;
        }
        return false;
    }
    // Can't have Delete method  !!
    @Override
    public boolean delete(ProjectDetails projectDetails) {
        return false;
    }



}
