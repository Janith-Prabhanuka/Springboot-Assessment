package com.assignment.Assignment.entity;

import com.assignment.Assignment.dto.UserEntityDto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private int id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column( nullable = false,unique=true)
    private String email;
    private long contactNo;
    @Column(name = "user_name", nullable = false,unique=true)
    private String userName;
    @Column( nullable = false)
    private String password;
    @Column( nullable = false)
    private int age;

    @ManyToMany
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionEntity> givenPermissions;

    public UserEntity() {
    }
    public void addPermission(PermissionEntity permissionEntity) {
        this.givenPermissions.add(permissionEntity);
    }

    public UserEntity(UserEntityDto userEntityDto) {
        this.firstName=userEntityDto.getFirstName();
        this.lastName = userEntityDto.getLastName();
        this.email = userEntityDto.getEmail();
        this.contactNo = userEntityDto.getContactNo();
        this.userName = userEntityDto.getUserName();
        this.password = userEntityDto.getPassword();
        this.age = userEntityDto.getAge();

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<PermissionEntity> getGivenPermissions() {
        return givenPermissions;
    }

    public void setGivenPermissions(Set<PermissionEntity> givenPermissions) {
        this.givenPermissions = givenPermissions;
    }

}
