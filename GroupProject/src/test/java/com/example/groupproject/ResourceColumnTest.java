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
public class ResourceColumnTest {
    @Autowired
    private ProjectDetailRepository projectDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ResourceColumnRepository resourceColumnRepository;

    @Test
    @Transactional
    @Rollback(true)
    public void ResourceColumnTest() {
        Project project = new Project();
        User user = new User();
        Resource resource = new Resource();
        ProjectDetail projectDetail = new ProjectDetail();
        ResourceColumn resourceColumn = new ResourceColumn();

        user.setUserId(10);
        user.setTitle("Mr.");
        user.setFirstName("H");
        user.setEmail("123@gmail.com");
        userRepository.save(user);

        resource.setResourceCode("000000");
        resourceRepository.save(resource);

        project.setProjectName("project1");
        projectRepository.save(project);

        projectDetail.setProject(project);
        projectDetailRepository.save(projectDetail);

        resourceColumn.setProjectDetails(projectDetail);
        resourceColumn.setResources(resource);
        resourceColumnRepository.save(resourceColumn);

        List<ResourceColumn> list = resourceColumnRepository.findAll();
        Assert.assertEquals(1,list.size());
        Assert.assertEquals(resourceColumn.getProjectDetails(), list.get(0).getProjectDetails());
    }
}
