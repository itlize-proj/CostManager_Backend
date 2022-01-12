package com.example.groupproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceId;
    @Column
    private String resourceCode;
    @Column
    private String resourceName;

    @CreatedDate
    private java.sql.Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @JsonIgnore
    @OneToMany(targetEntity = ResourceToProject.class, cascade = CascadeType.REMOVE, mappedBy = "resources")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ResourceToProject> projects = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = ResourceToProject.class, cascade = CascadeType.REMOVE, mappedBy = "resources")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ResourceColumn> resourceColumns = new ArrayList<>();

    public Resources() {
    }

    public Resources(int resourceId, String resourceCode, String resourceName, Date timeCreated, Date lastUpdated, List<ResourceToProject> projects, List<ResourceColumn> resourceColumns) {
        this.resourceId = resourceId;
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.projects = projects;
        this.resourceColumns = resourceColumns;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<ResourceToProject> getProjects() {
        return projects;
    }

    public void setProjects(List<ResourceToProject> projects) {
        this.projects = projects;
    }

    public List<ResourceColumn> getResourceDetails() {
        return resourceColumns;
    }

    public void setResourceDetails(List<ResourceColumn> resourceColumns) {
        this.resourceColumns = resourceColumns;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "resourceId=" + resourceId +
                ", resourceCode=" + resourceCode +
                ", resourceName='" + resourceName + '\'' +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", projects=" + projects +
                ", resourceDetails=" + resourceColumns +
                '}';
    }
}
