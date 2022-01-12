package com.example.groupproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    @Column
    private String projectName;
    @CreatedDate
    private Date timeCreated;
    @ManyToOne(targetEntity = User.class)
    private User user;


    @JsonIgnore
    @OneToMany(targetEntity = ResourceToProject.class, cascade = CascadeType.REMOVE, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ResourceToProject> resources = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = ProjectDetails.class, cascade = CascadeType.REMOVE, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProjectDetails> projectDetails = new ArrayList<>();


    public Project() {
    }


    public Project(Integer projectId, String projectName, Date timeCreated, User user, List<ResourceToProject> resources, List<ProjectDetails> projectDetails) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.timeCreated = timeCreated;
        this.user = user;
        this.resources = resources;
        this.projectDetails = projectDetails;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ResourceToProject> getResources() {
        return resources;
    }

    public void setResources(List<ResourceToProject> resources) {
        this.resources = resources;
    }

    public List<ProjectDetails> getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(List<ProjectDetails> projectDetails) {
        this.projectDetails = projectDetails;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", timeCreated=" + timeCreated +
                ", user=" + user +
                ", resources=" + resources +
                ", projectDetails=" + projectDetails +
                '}';
    }
}
