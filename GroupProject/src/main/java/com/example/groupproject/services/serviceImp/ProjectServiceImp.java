package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import com.example.groupproject.repositories.ProjectDAO;
import com.example.groupproject.repositories.UserDAO;
import com.example.groupproject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.boot.system.SystemProperties.get;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<Project> findByUser(User user) {
        if (user == null) {
            System.out.println("User is not existed");
        }
        return projectDAO.findAllByUser(user).get();
    }


    @Override
    public void createByUser(User user, Project project) {
        if (user == null || project == null) {
            System.out.println("user is not existed or project is empty");
        }
        try {
            projectDAO.save(project);
            HashSet<Project> list = new HashSet<>();
            list.add(project);
            user.setProjects(list);
            userDAO.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByUser(User user, Integer projectId) {
        Project project = projectDAO.findById(projectId).orElse(null);
        projectDAO.delete(project);
    }

    @Override
    public List<Project> getAll() {
        return projectDAO.findAll();
    }

    @Override
    public List<Project> getAllByUser(User user) {
        return projectDAO.findAllByUser(user).get();
    }

    @Override
    public Project getProjectByProjectName(String name) {
        return projectDAO.findProjectByProjectName(name).get();
    }
}
