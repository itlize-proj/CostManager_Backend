package com.example.groupproject.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resource_to_project")
public class ResourceToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceToProjectId;

    @CreatedDate
    private Date timeCreated;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Project project;

    @ManyToOne(targetEntity = Resource.class, cascade = CascadeType.DETACH)
    private Resource resource;

    public ResourceToProject() {
    }

    public ResourceToProject(int resourceToProjectId, Date timeCreated, Project project, Resource resource) {
        this.resourceToProjectId = resourceToProjectId;
        this.timeCreated = timeCreated;
        this.project = project;
        this.resource = resource;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public int getResourceToProjectId() {
        return resourceToProjectId;
    }

    public void setResourceToProjectId(int resourceToProjectId) {
        this.resourceToProjectId = resourceToProjectId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resource getResources() {
        return resource;
    }

    public void setResources(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ResourceToProject{" +
                "resourceToProjectId=" + resourceToProjectId +
                ", timeCreated=" + timeCreated +
                ", project=" + project +
                ", resource=" + resource +
                '}';
    }
}
