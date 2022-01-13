package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Resource;
import com.example.groupproject.repositories.ResourceRepository;
import com.example.groupproject.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;
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
    public boolean create(Resource resource) {
        if (resource == null && !resourceRepository.findResourceByResourceCode(resource.getResourceCode()).isPresent()) {
            System.out.println("Resource is Empty/Resource already exists");
            return false;
        } else {
            Instant now = Instant.now();
            resource.setLastUpdated(Date.from(now));
            resource.setTimeCreated(Date.from(now));
            resourceRepository.save(resource);
            return true;
        }
    }

    @Override
    public boolean update(Resource resource) {
        if (resource == null && resourceRepository.findResourceByResourceCode(resource.getResourceCode()).isPresent()) {
            System.out.println("Resource is Empty/doesn't exist");
            return false;
        } else {
            Instant now = Instant.now();
            resource.setLastUpdated(Date.from(now));
            resourceRepository.save(resource);
            return true;
        }
    }
    // Can't have Delete method  !!

}
