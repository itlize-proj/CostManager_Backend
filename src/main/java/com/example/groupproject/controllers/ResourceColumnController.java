package com.example.groupproject.controllers;

import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.entities.Resource;
import com.example.groupproject.entities.ResourceColumn;
import com.example.groupproject.services.ProjectDetailService;
import com.example.groupproject.services.ResourceColumnService;
import com.example.groupproject.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resourceColumn")
public class ResourceColumnController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ProjectDetailService projectDetailService;
    @Autowired
    private ResourceColumnService resourceColumnService;

    @GetMapping("/getResourceToProjectById/{id}")
    public ResponseEntity<?> getResourceColumnById(@PathVariable Integer id) {
        ResourceColumn resourceColumn = resourceColumnService.get(id);
        if(resourceColumn.getResourceColumnId() != 0)
            return new ResponseEntity<>(resourceColumn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getResourceColumnByResourceAndProjectDetail")
    public ResponseEntity<?> getResourceColumnByResourceAndProjectDetail(@RequestParam Integer projectDetailId, String resourceCode) {
        ProjectDetail projectDetail = projectDetailService.get(projectDetailId);
        Resource resource = resourceService.getByResourceCode(resourceCode);
        ResourceColumn resourceColumn = resourceColumnService.get(resource, projectDetail);
        if(resourceColumn.getResourceColumnId() != 0)
            return new ResponseEntity<>(resourceColumn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getResourceColumnByProjectDetail")
    public ResponseEntity<?> getResourceColumnByProjectDetail(@RequestParam Integer projectDetailId) {
        ProjectDetail projectDetail = projectDetailService.get(projectDetailId);
        if(projectDetailService.get(projectDetailId) == null)
            return new ResponseEntity<>("ProjectDetail not Found", HttpStatus.NOT_FOUND);
        List<ResourceColumn> list = resourceColumnService.get(projectDetail);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ResourceColumn resourceColumn) {
        boolean result = resourceColumnService.create(resourceColumn.getResources(), resourceColumn.getProjectDetails(), resourceColumn);
        if(result)
            return new ResponseEntity<>("Created Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ResourceColumn resourceColumn) {
        boolean result = resourceColumnService.update(resourceColumn);
        if(result)
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody ResourceColumn resourceColumn) {
        boolean result = resourceColumnService.delete(resourceColumn);
        if(result)
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
