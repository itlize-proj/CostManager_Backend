package com.example.groupproject.services;

import com.example.groupproject.entities.User;

import java.util.List;

public interface UserService {
    //CRUD
    //Create
    public boolean create(User user);
    //Read
    public User get(Integer userId);
    List<User> getAll();
    //Update
    public boolean update(User user, Integer userId);
    //Delete
    public boolean delete(User user);
}
