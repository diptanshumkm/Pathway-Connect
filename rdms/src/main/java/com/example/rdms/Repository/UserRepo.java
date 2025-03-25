package com.example.rdms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rdms.Model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long>{
    
}