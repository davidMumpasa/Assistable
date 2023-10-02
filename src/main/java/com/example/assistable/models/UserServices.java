package com.example.assistable.models;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServices  {

    @Autowired
   private UserRepo userRepo;


    public UserEntity save(UserEntity users){

        return userRepo.save(users);
    }


}
