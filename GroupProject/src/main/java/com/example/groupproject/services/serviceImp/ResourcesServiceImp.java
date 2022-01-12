package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Resources;
import com.example.groupproject.repositories.ResourcesDAO;
import com.example.groupproject.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourcesServiceImp implements ResourceService {
    @Autowired
    private ResourcesDAO resourcesDAO;


    @Override
    public Resources getByResourceCode(String code) {
        return resourcesDAO.findResourcesByResourceCode(code).get();
    }

    @Override
    public Resources getByResourceName(String name) {
        return resourcesDAO.findResourcesByResourceName(name).get();
    }

    @Override
    public List<Resources> getAll() {
        return resourcesDAO.findAll();
    }

    @Override
    public void addResource(Resources resources) {
        if (resources == null) {
            System.out.println("Resource is Empty");
        } else {
            resourcesDAO.save(resources);
        }
    }

    @Override
    public void updateResource(Resources resources) {
        if (resources == null) {
            System.out.println("Resource is Empty");
        } else {
            resourcesDAO.save(resources);
        }
    }
    // Can't have Delete method  !!

}
