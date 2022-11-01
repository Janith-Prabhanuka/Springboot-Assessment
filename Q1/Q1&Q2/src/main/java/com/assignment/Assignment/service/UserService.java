package com.assignment.Assignment.service;

import com.assignment.Assignment.dto.UserEntityDto;
import com.assignment.Assignment.entity.UserEntity;
import com.assignment.Assignment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public UserEntityDto getById(int id) throws Exception {
        if (userRepo.existsById(id)) {
            return new UserEntityDto(userRepo.getById(id));
        } else {
            throw new Exception("User not exists for User ID:" + id);
        }
    }

    public List<UserEntityDto> getUsersByAge(int age) throws Exception {
        if (age>0) {
             List<UserEntityDto> userDtoList = new ArrayList<>();
             List<UserEntity> userEntityList = userRepo.findByAge(age, Sort.by("firstName"));
            for (UserEntity userEntity:userEntityList
                 ) {
                userDtoList.add(new UserEntityDto(userEntity));
            }
             return userDtoList ;
        } else {
            throw new Exception("No Users in this age:" + age);
        }
    }

    public UserEntityDto addUser(UserEntityDto userEntityDto) throws Exception {
        if (!userEntityDto.isValid(0)) {
            throw new Exception("Missing some properties for given User");
        }
        if(userRepo.existsUserEntityByEmail(userEntityDto.getEmail())){
            UserEntity userEntity= userRepo.getByEmail(userEntityDto.getEmail());
            String user =userEntity.getUserName();
            String email=userEntity.getEmail();
            throw new Exception("Given email:"+email+" is already assign with User:"+user);
        }
        if(userRepo.existsUserEntityByUserName(userEntityDto.getUserName())) {
            throw new Exception("Given User Name Already taken");
        }
        UserEntity userEntity=new UserEntity(userEntityDto);
        return new UserEntityDto(userRepo.save(userEntity));

    }

    public UserEntityDto updateById(UserEntityDto userEntityDto, int id) throws Exception {
        if (!userEntityDto.isValid(id)) {
            throw new Exception("Missing some properties for given User");
        }
        if (!userRepo.existsById(id)) {
            throw new Exception("User not exists for ID:" + id);
        }
        UserEntity userEntity= new UserEntity(userEntityDto);
        userEntity.setId(id);
        return new UserEntityDto(userRepo.save(userEntity));
    }

    public UserEntityDto updateByEmail(UserEntityDto userEntityDto, String email) throws Exception {
        int id;
        try{
            UserEntity userEntity= userRepo.getByEmail(email);
            id =userEntity.getId();
            userEntityDto.setId(id);
        }catch (Exception e){
            throw new Exception("User not exists for email:" + email);
        }
        if (!userEntityDto.isValid(id)) {
            throw new Exception("Missing some properties for given User");
        }

        UserEntity userEntity= new UserEntity(userEntityDto);
        userEntity.setId(id);
        return new UserEntityDto(userRepo.save(userEntity));
    }

    public UserEntityDto delete(int id) throws Exception {
        if (userRepo.existsById(id)) {
            UserEntity userEntity=(userRepo.getById(id));
            userRepo.deleteById(id);
            return new UserEntityDto(userEntity);
        } else {
            throw new Exception("User not exists for ID:" + id);
        }
    }
}
