package com.example.groupproject.controllers;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.Resource;
import com.example.groupproject.entities.ResourceToProject;
import com.example.groupproject.services.ProjectService;
import com.example.groupproject.services.ResourceService;
import com.example.groupproject.services.ResourceToProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resourceToProject")
public class ResourceToProjectController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceToProjectService resourceToProjectService;

    @GetMapping("/getResourceToProjectById")
    public ResponseEntity<?> getResourceToProjectById(@RequestParam Integer id) {
        ResourceToProject resourceToProject = resourceToProjectService.get(id);
        if(resourceToProject != null)
            return new ResponseEntity<>(resourceToProject, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getResourceToProjectByResourceAndProject")
    public ResponseEntity<?> getResourceToProjectByResourceAndProject(@RequestParam String projectName, String resourceCode) {
        Project project = projectService.getProjectByProjectName(projectName);
        Resource resource = resourceService.getByResourceCode(resourceCode);
        ResourceToProject resourceToProject = resourceToProjectService.get(resource, project);
        if(resourceToProject.getResourceToProjectId() != 0)
            return new ResponseEntity<>(resourceToProject, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getResourceToProjectByProject")
    public ResponseEntity<?> getResourceToProjectByProject(@RequestParam String projectName) {
        Project project = projectService.getProjectByProjectName(projectName);
        List<ResourceToProject> list = resourceToProjectService.get(project);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ResourceToProject resourceToProject) {
        boolean result = resourceToProjectService.create(resourceToProject.getResources(), resourceToProject.getProject(), resourceToProject);
        if(result)
            return new ResponseEntity<>("Created Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ResourceToProject resourceToProject) {
        boolean result = resourceToProjectService.update(resourceToProject);
        if(result)
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody ResourceToProject resourceToProject) {
        boolean result = resourceToProjectService.delete(resourceToProject);
        if(result)
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
