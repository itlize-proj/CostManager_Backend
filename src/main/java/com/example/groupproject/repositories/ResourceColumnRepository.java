package com.example.groupproject.repositories;

import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.entities.ResourceColumn;
import com.example.groupproject.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceColumnRepository extends JpaRepository<ResourceColumn,Integer> {
    public Optional<ResourceColumn> findByResourceColumnId(int resourceColumnId);
    public Optional<ResourceColumn> findByResourceAndProjectDetail(ProjectDetail projectDetail, Resource resource);
    public Optional<List<ResourceColumn>> findByProjectDetail(ProjectDetail projectDetail);
}
