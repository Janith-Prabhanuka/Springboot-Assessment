package com.assignment.Assignment.dto;

import com.assignment.Assignment.entity.UserEntity;

import java.io.Serializable;

/**
 * A DTO for the {@link com.assignment.Assignment.entity.UserEntity} entity
 */
public class UserEntityDto implements Serializable {
    private int id= 0;
    private String firstName;
    private String lastName;
    private String email;
    private long contactNo;
    private String userName;
    private String password;
    private int age;

    public UserEntityDto() {
    }

    public UserEntityDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.email = userEntity.getEmail();
        this.contactNo = userEntity.getContactNo();
        this.userName = userEntity.getUserName();
        this.password = userEntity.getPassword();
        this.age = userEntity.getAge();
    }

    public boolean isValid(int id){
        return (this.id ==id||!this.firstName.isEmpty()||!this.lastName.isEmpty()
                ||!this.email.isEmpty()||!this.userName.isEmpty()||!this.password.isEmpty()||this.age>0);
    }

    public int getId() {
        return id;
    }

    public UserEntityDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntityDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntityDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntityDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public long getContactNo() {
        return contactNo;
    }

    public UserEntityDto setContactNo(long contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserEntityDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntityDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserEntityDto setAge(int age) {
        this.age = age;
        return this;
    }

}