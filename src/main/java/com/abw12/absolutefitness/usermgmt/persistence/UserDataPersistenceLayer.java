package com.abw12.absolutefitness.usermgmt.persistence;

import com.abw12.absolutefitness.usermgmt.entity.UserDataDAO;
import com.abw12.absolutefitness.usermgmt.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataPersistenceLayer {

    @Autowired
    private UserDataRepository userRepo;

    public UserDataDAO getUser(String userId){
        return userRepo.getUserDataByUserId(userId).orElseThrow(() ->
                new RuntimeException(String.format("Cannot find user data by userId : %s",userId)));
    }

    public UserDataDAO upsertUserData(UserDataDAO userData){
        return userRepo.save(userData);
    }
}
