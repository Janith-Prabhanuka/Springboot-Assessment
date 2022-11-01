package com.assignment.Assignment.controller;
import com.assignment.Assignment.dto.ResponseWrapper;
import com.assignment.Assignment.dto.UserEntityDto;
import com.assignment.Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping("/{id}")
    public ResponseWrapper getByID(@PathVariable(value = "id") int id) {
        try {
            return new ResponseWrapper(200, userService.getById(id),"Success");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

    @GetMapping("/filter/{age}")
    public ResponseWrapper getByAge(@PathVariable(value = "age") int age) {
        try {
            return new ResponseWrapper(200, userService.getUsersByAge(age),"Success");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseWrapper addUser(@RequestBody UserEntityDto userEntityDto) {
        try {
            return new ResponseWrapper(200, userService.addUser(userEntityDto),"Successfully add New User");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseWrapper updateById(@RequestBody UserEntityDto userEntityDto, @PathVariable(value = "id") int id) {
        try {
            return new ResponseWrapper(200, userService.updateById(userEntityDto, id),"Successfully Updated");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

    @PutMapping("/email/{email}")
    public ResponseWrapper updateById(@RequestBody UserEntityDto userEntityDto, @PathVariable(value = "email") String email) {
        try {
            return new ResponseWrapper(200, userService.updateByEmail(userEntityDto, email),"Successfully Updated");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseWrapper deleteWarehouse(@PathVariable(value = "id") int id) {
        try {
            return new ResponseWrapper(200, userService.delete(id),"Successfully Deleted");
        } catch (Exception e) {
            return new ResponseWrapper(400, e.getMessage());
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
