package com.example.groupproject.repositories;

import com.example.groupproject.entities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourcesDAO extends JpaRepository<Resources,Integer> {
    Optional<Resources> findResourcesByResourceCode(String resourceCode);
    Optional<Resources> findResourcesByResourceName(String resourceName);
    List<Resources> findAll();
}
