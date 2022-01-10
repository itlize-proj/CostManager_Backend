package com.example.groupproject.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resourceToProject")
public class ResourceToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceToProjectId;

    @CreatedDate
    private Date timeCreated;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Project project;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Resources resources;

    public ResourceToProject() {
    }

    public ResourceToProject(int resourceToProjectId, Date timeCreated, Project project, Resources resources) {
        this.resourceToProjectId = resourceToProjectId;
        this.timeCreated = timeCreated;
        this.project = project;
        this.resources = resources;
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

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ResourceToProject{" +
                "resourceToProjectId=" + resourceToProjectId +
                ", timeCreated=" + timeCreated +
                ", project=" + project +
                ", resources=" + resources +
                '}';
    }
}
