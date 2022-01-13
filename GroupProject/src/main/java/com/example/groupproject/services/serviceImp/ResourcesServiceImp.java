package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Resource;
import com.example.groupproject.repositories.ResourceRepository;
import com.example.groupproject.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourcesServiceImp implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;


    @Override
    public Resource getByResourceCode(String code) {
        return resourceRepository.findResourceByResourceCode(code).get();
    }

    @Override
    public Resource getByResourceName(String name) {
        return resourceRepository.findResourceByResourceName(name).get();
    }

    @Override
    public List<Resource> getAll() {
        return resourceRepository.findAll();
    }

    @Override
    public void addResource(Resource resource) {
        if (resource == null) {
            System.out.println("Resource is Empty");
        } else {
            resourceRepository.save(resource);
        }
    }

    @Override
    public void updateResource(Resource resource) {
        if (resource == null) {
            System.out.println("Resource is Empty");
        } else {
            resourceRepository.save(resource);
        }
    }
    // Can't have Delete method  !!

}
