package com.example.groupproject.services;

import com.example.groupproject.entities.Resource;

import java.util.List;

public interface ResourceService {
    // get
    Resource getByResourceCode(String code);

    Resource getByResourceName(String name);

    List<Resource> getAll();

    boolean create(Resource resource);

    boolean update(Resource resource);
}
