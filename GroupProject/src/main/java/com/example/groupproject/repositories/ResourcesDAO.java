package com.example.groupproject.repositories;

import com.example.groupproject.entities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesDAO extends JpaRepository<Resources,Integer> {
}
