package com.example.groupproject.repositories;

import com.example.groupproject.GroupProjectApplication;
import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import com.example.groupproject.repositories.ProjectDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProjectDAOTest {
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private UserDAO userDAO;
    @Test
    @Transactional
    void findByProjectId() {
        Project project = new Project();
        project.setProjectName("project1");
        projectDAO.save(project);

        Optional<Project> projectTest = projectDAO.findByProjectId(project.getProjectId());
        Assert.assertNotNull(projectTest.get());
    }

    @Test
    @Transactional
    void findAllByUser() {
        Project project1 = new Project();
        Project project2 = new Project();
        User user = new User();
        user.setUserId(1);
        project1.setUser(user);
        project2.setUser(user);

        userDAO.save(user);
        projectDAO.save(project1);
        projectDAO.save(project2);

        Optional<List<Project>> projects = projectDAO.findAllByUser(user);
        Assert.assertNotNull(projects.get());
        if(projects.get() != null)
            Assert.assertEquals(projects.get().get(0), project1);
    }

    @Test
    @Transactional
    void findProjectByProjectName() {
        Project project = new Project();
        project.setProjectName("projectTest");
        projectDAO.save(project);
        Optional<Project> projectTest = projectDAO.findProjectByProjectName("projectTest");
        Assert.assertNotNull(projectTest.get());
    }

    @Test
    @Transactional
    void findAll() {
        Project project = new Project();
        project.setProjectName("projectTest");
        projectDAO.save(project);
        List<Project> projects = projectDAO.findAll();
        Assert.assertNotNull(projects);
    }
}