package com.assignment.Assignment.controller;

import com.assignment.Assignment.dto.PermissionDto;
import com.assignment.Assignment.dto.ResponseWrapper;
import com.assignment.Assignment.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("")
    public ResponseWrapper addPermission(@RequestBody PermissionDto permissionDto) {
        try {
            return new ResponseWrapper(200, permissionService.addPermission(permissionDto),"Successfully add New Permission");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

}
