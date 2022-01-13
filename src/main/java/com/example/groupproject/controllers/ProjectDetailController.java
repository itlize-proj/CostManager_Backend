package com.example.groupproject.controllers;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.services.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projectDetails")
public class ProjectDetailController {
    @Autowired
    private ProjectDetailService projectDetailService;

    @GetMapping("/getProjectDetailById/{id}")
    public ResponseEntity<?> getProjectDetailsById (@PathVariable Integer id) {
        ProjectDetail projectDetail = projectDetailService.get(id);
        return new ResponseEntity<>(projectDetail, HttpStatus.OK);
    }

    @GetMapping("/getProjectDetailByProject")
    public ResponseEntity<?> getProjectDetailByProject(@RequestBody Project project) {
        List<ProjectDetail> list = projectDetailService.get(project);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/createProjectDetail")
    public ResponseEntity<?> createProjectDetail(@RequestBody ProjectDetail projectDetail, @RequestBody Project project) {
        projectDetailService.create(projectDetail, project);
        return new ResponseEntity<>("Create Successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProjectDetail projectDetail) {
        projectDetailService.update(projectDetail);
        return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
    }
}
