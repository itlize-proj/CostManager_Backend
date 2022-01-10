package com.example.groupproject.repositories;

import com.example.groupproject.entities.ResourceColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceColumnDAO extends JpaRepository<ResourceColumn,Integer> {
}
