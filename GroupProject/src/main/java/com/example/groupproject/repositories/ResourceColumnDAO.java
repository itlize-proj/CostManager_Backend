package com.example.groupproject.repositories;

import com.example.groupproject.entities.ProjectDetails;
import com.example.groupproject.entities.ResourceColumn;
import com.example.groupproject.entities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceColumnDAO extends JpaRepository<ResourceColumn,Integer> {
    public Optional<ResourceColumn> findByResourceColumnId(int resourceColumnId);
    public Optional<ResourceColumn> findByResourcesAndProjectDetails(ProjectDetails projectDetails, Resources resources);
    public Optional<List<ResourceColumn>> findByProjectDetails(ProjectDetails projectDetails);
}
