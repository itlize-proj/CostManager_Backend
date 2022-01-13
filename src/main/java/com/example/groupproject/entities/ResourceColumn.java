package com.example.groupproject.entities;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resource_column")
public class ResourceColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceColumnId;
    @Column
    private String detailValue;
    @Column
    private String formulaValue;
    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = Resource.class, cascade = CascadeType.DETACH)
    private Resource resource;

    @ManyToOne(targetEntity = ProjectDetail.class, cascade = CascadeType.DETACH)
    private ProjectDetail projectDetail;

    public ResourceColumn() {
    }

    public ResourceColumn(int resourceColumnId, String detailValue, String formulaValue, Date timeCreated, Date lastUpdated, Resource resource, ProjectDetail projectDetail) {
        this.resourceColumnId = resourceColumnId;
        this.detailValue = detailValue;
        this.formulaValue = formulaValue;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.resource = resource;
        this.projectDetail = projectDetail;
    }

    public int getResourceColumnId() {
        return resourceColumnId;
    }

    public void setResourceColumnId(int resourceDetailId) {
        this.resourceColumnId = resourceDetailId;
    }

    public String getDetailValue() {
        return detailValue;
    }

    public void setDetailValue(String detailValue) {
        this.detailValue = detailValue;
    }

    public String getFormulaValue() {
        return formulaValue;
    }

    public void setFormulaValue(String formulaValue) {
        this.formulaValue = formulaValue;
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

    public Resource getResources() {
        return resource;
    }

    public void setResources(Resource resource) {
        this.resource = resource;
    }

    public ProjectDetail getProjectDetails() {
        return projectDetail;
    }

    public void setProjectDetails(ProjectDetail projectDetail) {
        this.projectDetail = projectDetail;
    }

    @Override
    public String toString() {
        return "ResourceColumn{" +
                "resourceDetailId=" + resourceColumnId +
                ", detailValue='" + detailValue + '\'' +
                ", formulaValue='" + formulaValue + '\'' +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", resource=" + resource +
                ", projectDetail=" + projectDetail +
                '}';
    }
}
