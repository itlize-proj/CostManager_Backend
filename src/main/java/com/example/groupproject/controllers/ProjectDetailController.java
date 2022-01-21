package com.example.groupproject.controllers;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.services.ProjectDetailService;
import com.example.groupproject.services.ProjectService;
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
    @Autowired
    private ProjectService projectService;
    @GetMapping
    public String Hello() {
        return "Hello";
    }

    @GetMapping("/getProjectDetailById/{id}")
    public ResponseEntity<?> getProjectDetailsById (@PathVariable Integer id) {
        ProjectDetail projectDetail = projectDetailService.get(id);
        return new ResponseEntity<>(projectDetail, HttpStatus.OK);
    }

    @GetMapping("/getProjectDetailByProject")
    public ResponseEntity<?> getProjectDetailByProject(@RequestParam String projectName) {
        Project project = projectService.getProjectByProjectName(projectName);
        if(project == null)
            return new ResponseEntity<>("Project does not exist", HttpStatus.PRECONDITION_FAILED);
        List<ProjectDetail> list = projectDetailService.get(project);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/createProjectDetail")
    public ResponseEntity<?> createProjectDetail(@RequestBody ProjectDetail projectDetail) {
        boolean result = projectDetailService.create(projectDetail, projectDetail.getProject());
        if(result)
            return new ResponseEntity<>("Created Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProjectDetail projectDetail) {
        boolean result = projectDetailService.update(projectDetail);
        if(result)
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
