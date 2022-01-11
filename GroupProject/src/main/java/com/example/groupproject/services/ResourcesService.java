package com.example.groupproject.services;

import com.example.groupproject.entities.Resources;
import com.example.groupproject.repositories.ResourcesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.spi.ResolveResult;
import java.util.Comparator;
import java.util.List;

@Service
public class ResourcesService {
    @Autowired
    private ResourcesDAO resourcesDAO;

    // GET
    // get resource by ID
    public Resources getById(int id) {
        return resourcesDAO.findById(id).get();
    }
    // get resource by Name
    public Resources getByName(String name) {
        List<Resources> list = resourcesDAO.findAll();
        list.stream().filter(r -> (r.getResourceName().equals(name)));
        Resources resources = list.get(0);
        return resources;
    }
    // get by Resource Code
    public Resources getByCode (String code) {
        List<Resources> list = resourcesDAO.findAll();
        list.stream().filter(r -> (r.getResourceName().equals(code)));
        Resources resources = list.get(0);
        return resources;
    }
    // Update
    public void update (Resources resources) {
        resourcesDAO.save(resources);
    }
    // Add
    public void addResources(Resources resources) {
        resourcesDAO.save(resources);
    }
    // Can't have Delete method  !!

}
