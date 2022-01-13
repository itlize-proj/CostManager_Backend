package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.Project;
import com.example.groupproject.entities.ProjectDetail;
import com.example.groupproject.repositories.ProjectDetailRepository;
import com.example.groupproject.services.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailServiceImp implements ProjectDetailService {
    @Autowired
    private ProjectDetailRepository projectDetailRepository;

    @Override
    public boolean create(ProjectDetail projectDetail, Project project) {
        // check if exists
        if(get(projectDetail.getDetailId()) == null)
            return false;
        try {
            projectDetail.setProject(project);
            projectDetailRepository.save(projectDetail);
            return true;
        } catch(Exception ex) {
            return false;
        }

    }

    @Override
    public ProjectDetail get(Integer detailId) {
        Optional<ProjectDetail> projectDetails = projectDetailRepository.findProjectDetailByDetailId(detailId);
        return projectDetails.isPresent()?projectDetails.get():null;
    }

    @Override
    public List<ProjectDetail> get(Project project) {
        Optional<List<ProjectDetail>> projectDetails = projectDetailRepository.findProjectDetailByProject(project);
        return projectDetails.isPresent()?projectDetails.get():null;
    }

    // Update
    @Override
    public boolean update(ProjectDetail projectDetail) {
        if(get(projectDetail.getDetailId()) == null) {
            projectDetailRepository.save(projectDetail);
            return true;
        }
        return false;
    }
    // Can't have Delete method  !!
    @Override
    public boolean delete(ProjectDetail projectDetail) {
        return false;
    }



}
