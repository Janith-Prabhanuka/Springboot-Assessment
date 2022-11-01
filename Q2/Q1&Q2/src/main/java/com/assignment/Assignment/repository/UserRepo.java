package com.assignment.Assignment.repository;

import com.assignment.Assignment.entity.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    default UserEntity getById(int id){
        return this.findById(id).get();
    }

    List<UserEntity> findByAge(int age, Sort sort);

    UserEntity getByEmail(String email);

    boolean existsUserEntityByEmail(String email);
    boolean existsUserEntityByUserName(String Username);


}
