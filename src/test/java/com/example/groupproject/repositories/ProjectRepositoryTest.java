package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByProjectId() {
        Project project = new Project();
        project.setProjectName("project1");
        projectRepository.save(project);

        Optional<Project> projectTest = projectRepository.findByProjectId(project.getProjectId());
        Assert.assertNotNull(projectTest.get());
    }

    @Test
    void findAllByUser() {
        Project project1 = new Project();
        project1.setProjectName("project1");
        Project project2 = new Project();
        project2.setProjectName("project2");
        User user = new User();

        userRepository.save(user);

        project1.setUser(user);
        project2.setUser(user);

        projectRepository.save(project1);
        projectRepository.save(project2);

        Optional<List<Project>> projects = projectRepository.findAllByUser(user);
        Assert.assertNotNull(projects.get());
        if(projects.get() != null)
            Assert.assertEquals(projects.get().get(0), project1);
    }

    @Test
    void findProjectByProjectName() {
        Project project = new Project();
        project.setProjectName("projectTest");
        projectRepository.save(project);
        Optional<Project> projectTest = projectRepository.findProjectByProjectName("projectTest");
        Assert.assertNotNull(projectTest.get());
    }

    @Test
    void findAll() {
        Project project = new Project();
        project.setProjectName("projectTest");
        projectRepository.save(project);
        List<Project> projects = projectRepository.findAll();
        Assert.assertNotNull(projects);
    }
}