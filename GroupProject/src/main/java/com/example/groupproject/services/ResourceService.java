package com.example.groupproject.services;

import com.example.groupproject.entities.Resources;

import java.util.List;

public interface ResourceService {
    // get
    Resources getByResourceCode(String code);

    Resources getByResourceName(String name);

    List<Resources> getAll();

    void addResource(Resources resources);

    void updateResource(Resources resources);
}
