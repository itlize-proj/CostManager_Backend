package com.example.groupproject;

import com.example.groupproject.entities.*;
import com.example.groupproject.repositories.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceColumnTest {
    @Autowired
    private ProjectDetailsDAO projectDetailsDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ResourcesDAO resourcesDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private ResourceColumnDAO resourceColumnDAO;

    @Test
    @Transactional
    @Rollback(true)
    public void ResourceColumnTest() {
        Project project = new Project();
        User user = new User();
        Resources resources = new Resources();
        ProjectDetails projectDetails = new ProjectDetails();
        ResourceColumn resourceColumn = new ResourceColumn();

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

        resourceColumn.setProjectDetails(projectDetails);
        resourceColumn.setResources(resources);
        resourceColumnDAO.save(resourceColumn);

        List<ResourceColumn> list = resourceColumnDAO.findAll();
        Assert.assertEquals(1,list.size());
        Assert.assertEquals(resourceColumn.getProjectDetails(), list.get(0).getProjectDetails());
    }
}
