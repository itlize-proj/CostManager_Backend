package com.example.groupproject.repositories;

import com.example.groupproject.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    Optional<Resource> findResourceByResourceCode(String resourceCode);
    Optional<Resource> findResourceByResourceName(String resourceName);
    List<Resource> findAll();
}
