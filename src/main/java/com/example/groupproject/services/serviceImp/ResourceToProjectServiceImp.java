package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.Resource;
import com.example.groupproject.entities.ResourceToProject;
import com.example.groupproject.repositories.ResourceToProjectRepository;
import com.example.groupproject.services.ResourceToProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ResourceToProjectServiceImp implements ResourceToProjectService {
    @Autowired
    ResourceToProjectRepository resourceToProjectRepository;
    @Override
    public boolean create(Resource resource, Project project, ResourceToProject resourceToProject) {
        if (resource != null || project != null || resourceToProject != null ) {
            resourceToProject.setProject(project);
            resourceToProject.setResources(resource);
            resourceToProjectRepository.save(resourceToProject);
        } else {
            System.out.println("Failed to create");
        }
        return false;
    }

    @Override
    public ResourceToProject get(Integer resourceToProjectId) {
        try {
            return resourceToProjectRepository.findById(resourceToProjectId).get();
        } catch (Exception E) {
            E.printStackTrace();
            return new ResourceToProject();
        }
    }

    @Override
    public ResourceToProject get(Resource resource, Project project) {
        try {
            return resourceToProjectRepository.findByProjectAndResource(project, resource);
        } catch (Exception E) {
            E.printStackTrace();
            return new ResourceToProject();
        }
    }

    @Override
    public List<ResourceToProject> get(Project project) {
        try {
            return resourceToProjectRepository.findByProject(project).get();
        } catch (Exception E) {
            E.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(ResourceToProject resourceToProject) {
        try {
            resourceToProjectRepository.save(resourceToProject);
            return true;
        } catch (Exception E) {
            E.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(ResourceToProject resourceToProject){
        try {
            int id = resourceToProject.getResourceToProjectId();
            resourceToProjectRepository.deleteById(id);
            return true;
        } catch (Exception E) {
            E.printStackTrace();
            return false;
        }
    }
}
