package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Project project1 = new Project();
        Project project2 = new Project();
        User user = new User();
        user.setUserId(1);
        project1.setUser(user);
        project2.setUser(user);

        userRepository.save(user);
        projectRepository.save(project1);
        projectRepository.save(project2);

        Optional<List<Project>> projects = projectRepository.findAllByUser(user);
        Assert.assertNotNull(projects.get());
        if(projects.get() != null)
            Assert.assertEquals(projects.get().get(0), project1);
    }

    @Test
    @Transactional
    void findProjectByProjectName() {
        Project project = new Project();
        project.setProjectName("projectTest");
        projectRepository.save(project);
        Optional<Project> projectTest = projectRepository.findProjectByProjectName("projectTest");
        Assert.assertNotNull(projectTest.get());
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
