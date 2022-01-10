package com.example.groupproject.repositories;

import com.example.groupproject.entities.ResourceToProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceToProjectDAO extends JpaRepository<ResourceToProject, Integer> {

}
