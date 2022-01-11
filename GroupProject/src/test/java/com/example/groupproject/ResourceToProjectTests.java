package com.example.groupproject;

import com.example.groupproject.entities.*;
import com.example.groupproject.repositories.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceToProjectTests {
    @Autowired
    private ProjectDetailsDAO projectDetailsDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ResourcesDAO resourcesDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private ResourceToProjectDAO resourceToProjectDAO;


    @Test
    @Transactional
    @Rollback(true)
    public void ProjectToResourceTest() {
        Project project = new Project();
        User user = new User();
        Resources resources = new Resources();
        ProjectDetails projectDetails = new ProjectDetails();
        ResourceToProject resourceToProject = new ResourceToProject();

        user.setUserId(10);
        user.setTitle("Mr.");
        user.setFirstName("H");
        user.setEmail("123@gmail.com");
        userDAO.save(user);

        resources.setResourceCode("000000");
        resourcesDAO.save(resources);

        project.setProjectName("project1");
        projectDAO.save(project);

        projectDetails.setProject(project);
        projectDetailsDAO.save(projectDetails);

        resourceToProject.setProject(project);
        resourceToProject.setResources(resources);
        resourceToProjectDAO.save(resourceToProject);

        List<ResourceToProject> list = resourceToProjectDAO.findAll();
        Assert.assertEquals(1,list.size());
        Assert.assertEquals(resourceToProject.getProject(), list.get(0).getProject());



    }
}
