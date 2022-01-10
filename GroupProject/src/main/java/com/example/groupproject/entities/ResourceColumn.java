package com.example.groupproject.entities;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resourceDetails")
public class ResourceColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceDetailId;

    @Column
    private String detailValue;
    @Column
    private String formulaValue;
    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = Resources.class, cascade = CascadeType.DETACH)
    private Resources resources;

    @ManyToOne(targetEntity = ProjectDetails.class, cascade = CascadeType.DETACH)
    private ProjectDetails projectDetails;

    public ResourceColumn() {
    }

    public ResourceColumn(int resourceDetailId, String detailValue, String formulaValue, Date timeCreated, Date lastUpdated, Resources resources, ProjectDetails projectDetails) {
        this.resourceDetailId = resourceDetailId;
        this.detailValue = detailValue;
        this.formulaValue = formulaValue;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.resources = resources;
        this.projectDetails = projectDetails;
    }

    public int getResourceDetailId() {
        return resourceDetailId;
    }

    public void setResourceDetailId(int resourceDetailId) {
        this.resourceDetailId = resourceDetailId;
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

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }

    @Override
    public String toString() {
        return "ResourceColumn{" +
                "resourceDetailId=" + resourceDetailId +
                ", detailValue='" + detailValue + '\'' +
                ", formulaValue='" + formulaValue + '\'' +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", resources=" + resources +
                ", projectDetails=" + projectDetails +
                '}';
    }
}
