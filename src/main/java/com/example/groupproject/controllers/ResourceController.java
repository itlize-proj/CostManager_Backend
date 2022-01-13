package com.example.groupproject.controllers;

import com.example.groupproject.entities.Resource;
import com.example.groupproject.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getByResourceCode/{code}")
    public ResponseEntity<?> getByResourceCode(@PathVariable String code) {
        Resource resource = resourceService.getByResourceCode(code);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    @GetMapping("/getByResourceName/{name}")
    public ResponseEntity<?> getByResourceName(@PathVariable String name) {
        Resource resource = resourceService.getByResourceName(name);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Resource> resources = resourceService.getAll();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Resource resource) {
        boolean success = resourceService.create(resource);
        if(success)
            return new ResponseEntity<>("Create Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Resource Object invalid/Already exists", HttpStatus.CONFLICT);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Resource resource) {
        boolean success = resourceService.update(resource);
        if(success)
            return new ResponseEntity<>("Create Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Resource Object invalid/Doesn't exists", HttpStatus.CONFLICT);
    }

}
