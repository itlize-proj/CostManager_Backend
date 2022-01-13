package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import com.example.groupproject.repositories.ProjectRepository;
import com.example.groupproject.repositories.UserRepository;
import com.example.groupproject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Project> findByUser(User user) {
        if (user == null) {
            System.out.println("User is not existed");
        }
        return projectRepository.findAllByUser(user).get();
    }


    @Override
    public void createByUser(User user, Project project) {
        if (user == null || project == null) {
            System.out.println("user is not existed or project is empty");
        }
        try {
            projectRepository.save(project);
            HashSet<Project> list = new HashSet<>();
            list.add(project);
            user.setProjects(list);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByUser(User user, Integer projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        projectRepository.delete(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAllByUser(User user) {
        return projectRepository.findAllByUser(user).get();
    }

    @Override
    public Project getProjectByProjectName(String name) {
        return projectRepository.findProjectByProjectName(name).get();
    }
}
