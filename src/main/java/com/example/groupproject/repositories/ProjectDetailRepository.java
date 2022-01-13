package com.example.groupproject.repositories;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Integer> {
    Optional<ProjectDetail> findProjectDetailByDetailId(int detailId);
    Optional<List<ProjectDetail>> findProjectDetailByProject(Project project);
}
