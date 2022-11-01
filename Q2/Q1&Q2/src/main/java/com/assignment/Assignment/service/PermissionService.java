package com.assignment.Assignment.service;


import com.assignment.Assignment.dto.PermissionDto;
import com.assignment.Assignment.entity.PermissionEntity;
import com.assignment.Assignment.repository.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;

    public PermissionDto addPermission(PermissionDto permissionDto) throws Exception {
        if (!permissionDto.isValid()) {
            throw new Exception("Missing some properties for given Permission");
        }
        if (permissionRepo.existsByName(permissionDto.getName())) {
            throw new Exception("Given Permission Name Already exists");
        }
        PermissionEntity permissionEntity = new PermissionEntity(permissionDto);
        return new PermissionDto(permissionRepo.save(permissionEntity));

    }

}

