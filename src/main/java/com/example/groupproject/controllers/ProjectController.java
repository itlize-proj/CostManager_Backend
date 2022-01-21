package com.example.groupproject.controllers;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.User;
import com.example.groupproject.services.ProjectService;
import com.example.groupproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Project> projectList = projectService.getAll();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping("/getProjectByUser")
    public ResponseEntity<?> getProjectByUser(@RequestParam Integer userId) {
        User user = userService.get(userId);
        List<Project> projectList = projectService.getByUser(user);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
    @GetMapping("/getProjectByName/{name}")
    public ResponseEntity<?> getProjectByName(@PathVariable String name){
        Project project = projectService.getProjectByProjectName(name);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @PostMapping("/createProject")
    public ResponseEntity<?> createProject(@RequestBody Project project) {
        projectService.createByUser(project.getUser(), project);
        return new ResponseEntity<>("Create Successful", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByUser(@RequestBody User user,@PathVariable Integer id) {
        projectService.deleteByUser(user, id);
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }


}
