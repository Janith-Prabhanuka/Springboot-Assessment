package com.assignment.Assignment.repository;

import com.assignment.Assignment.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<PermissionEntity, Integer> {

    boolean existsByName(String name);

    PermissionEntity getByName(String name);
}