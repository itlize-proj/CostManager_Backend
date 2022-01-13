package com.example.groupproject.controllers;

import com.example.groupproject.entities.User;
import com.example.groupproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById (@PathVariable Integer id) {
        User user = userService.get(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>("Create Successful", HttpStatus.OK);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> update( @PathVariable Integer userId, @RequestBody User user) {
        userService.update(user, userId);
        return new ResponseEntity<>("Update Successful", HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody User user) {
        userService.delete(user);
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }
}
