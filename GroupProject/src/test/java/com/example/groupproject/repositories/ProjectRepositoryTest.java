package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    @Transactional
    @DisplayName("find project by projectId")
    void findByProjectId() {
        Project project = new Project();
        project.setProjectName("project1");
        projectRepository.save(project);

        Optional<Project> projectTest = projectRepository.findByProjectId(project.getProjectId());
        Assert.assertNotNull(projectTest.get());
    }

    @Test
    @Transactional
    void findAllByUser() {
        User user = new User();
        userRepository.save(user);

        Project project1 = new Project();
        Project project2 = new Project();

        project1.setUser(user);
        project2.setUser(user);


        projectRepository.save(project1);
        projectRepository.save(project2);

        Optional<List<Project>> projects = projectRepository.findAllByUser(user);
        if(projects.isPresent())
            Assert.assertNotNull(projects.get());
        if(projects.get() != null)
            Assert.assertEquals(projects.get().get(0).getProjectName(), project1.getProjectName());
    }

    @Test
    @Transactional
    void findProjectByProjectName() {
        Project project = new Project();
        project.setProjectName("projectTest2");
        projectRepository.save(project);
        Optional<Project> projectTest = projectRepository.findProjectByProjectName("projectTest2");
        if(projectTest.isPresent())
            Assert.assertNotNull(projectTest.get());
        else
            Assert.fail("Project not found");
    }

    @Test
    @Transactional
    void findAll() {
        Project project = new Project();
        project.setProjectName("projectTest");
        projectRepository.save(project);
        List<Project> projects = projectRepository.findAll();
        Assert.assertNotNull(projects);
    }
}