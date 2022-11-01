package com.assignment.Assignment.dto;

import com.assignment.Assignment.entity.PermissionEntity;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link com.assignment.Assignment.entity.PermissionEntity} entity
 */
public class PermissionDto implements Serializable {
    private int id;
    private String name;

    public PermissionDto() {
    }

    public PermissionDto(@NotNull PermissionEntity permissionEntity) {
        this.id= permissionEntity.getId();
        this.name=permissionEntity.getName();
    }


    public boolean isValid() {
        return !this.name.isEmpty();
    }

    public PermissionDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public PermissionDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PermissionDto setName(String name) {
        this.name = name;
        return this;
    }

}