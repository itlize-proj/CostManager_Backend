package com.example.groupproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project_details")
public class ProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailId;
    @Column
    private int resourceId;
    @Column
    private String detailName;
    @Column
    private FormulaType formulaType;
    @Column
    private String formulaText;
    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;


    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Project project;


    @JsonIgnore
    @OneToMany(targetEntity = ResourceColumn.class, cascade = CascadeType.REMOVE, mappedBy = "projectDetails")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ResourceColumn> resourceColumns = new HashSet<>();

    public ProjectDetails() {
    }

    public ProjectDetails(int detailId, int resourceId, String detailName, FormulaType formulaType, String formulaText, Date timeCreated, Date lastUpdated, Project project, Set<ResourceColumn> resourceColumns) {
        this.detailId = detailId;
        this.resourceId = resourceId;
        this.detailName = detailName;
        this.formulaType = formulaType;
        this.formulaText = formulaText;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.project = project;
        this.resourceColumns = resourceColumns;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public FormulaType getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(FormulaType formulaType) {
        this.formulaType = formulaType;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<ResourceColumn> getResourceDetails() {
        return resourceColumns;
    }

    public void setResourceDetails(Set<ResourceColumn> resourceColumns) {
        this.resourceColumns = resourceColumns;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "detailId=" + detailId +
                ", resourceId=" + resourceId +
                ", detailName='" + detailName + '\'' +
                ", formulaType=" + formulaType +
                ", formulaText='" + formulaText + '\'' +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", project=" + project +
                ", resourceDetails=" + resourceColumns +
                '}';
    }
}
