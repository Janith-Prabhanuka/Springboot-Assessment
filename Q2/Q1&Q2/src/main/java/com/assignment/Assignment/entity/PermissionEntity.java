package com.assignment.Assignment.entity;

import com.assignment.Assignment.dto.PermissionDto;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "permission")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id", nullable = false)
    private int id;
    @Column(name = "permission_name", nullable = false,unique=true)
    private String name;


    @ManyToMany
    private Set<UserEntity> givenUsers;

    public PermissionEntity(String name) {

        this.name = name;
    }

    public PermissionEntity() {

    }
    public PermissionEntity(PermissionDto permissionDto) {
        this.name= permissionDto.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getGivenUsers() {
        return givenUsers;
    }

    public void setGivenUsers(Set<UserEntity> givenUsers) {
        this.givenUsers = givenUsers;
    }

}
