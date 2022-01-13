package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.entities.Resource;
import com.example.groupproject.entities.ResourceColumn;
import com.example.groupproject.repositories.ResourceColumnRepository;
import com.example.groupproject.services.ResourceColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceColumnServiceImp implements ResourceColumnService {
    @Autowired
    ResourceColumnRepository resourceColumnRepository;

    @Override
    public boolean create(Resource resource, ProjectDetail projectDetail, ResourceColumn resourceColumn) {
        if (resource != null || projectDetail != null || resourceColumn != null) {
            resourceColumn.setProjectDetails(projectDetail);
            resourceColumn.setResources(resource);
            resourceColumnRepository.save(resourceColumn);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public ResourceColumn get(Integer resourceColumnId) {
        if (resourceColumnId != null) {
            return resourceColumnRepository.findByResourceColumnId(resourceColumnId).get();
        } else {
            System.out.println("Can't find resource Column : " + resourceColumnId);
            return new ResourceColumn();
        }
    }

    @Override
    public ResourceColumn get(Resource resource, ProjectDetail projectDetail) {
        if (resource != null || projectDetail != null) {
            return resourceColumnRepository.findByResourceAndProjectDetail(projectDetail,resource).get();
        } else {
            System.out.println("Can't find resource Column");
            return new ResourceColumn();
        }
    }

    @Override
    public List<ResourceColumn> get(ProjectDetail projectDetail) {
        if (projectDetail != null) {
            return resourceColumnRepository.findByProjectDetail(projectDetail).get();
        } else {
            System.out.println("Can't find resource Column");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(ResourceColumn resourceColumn) {
        if (resourceColumn == null) {
            System.out.println("Can't update the Resource Column");
            return false;
        } else {
            resourceColumnRepository.save(resourceColumn);
            return true;
        }
    }

    @Override
    public boolean delete(ResourceColumn resourceColumn) {
        try {
            int id = resourceColumn.getResourceColumnId();
            if (resourceColumnRepository.findByResourceColumnId(id).get() != null) {
                resourceColumnRepository.delete(resourceColumn);
                return true;
            } else {
                System.out.println("Can't find the Resource Column");
                return false;
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return false;
    }
}
