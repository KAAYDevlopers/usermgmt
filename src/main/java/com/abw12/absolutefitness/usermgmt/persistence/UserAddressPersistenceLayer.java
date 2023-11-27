package com.abw12.absolutefitness.usermgmt.persistence;

import com.abw12.absolutefitness.usermgmt.entity.UserAddressDAO;
import com.abw12.absolutefitness.usermgmt.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAddressPersistenceLayer {

    @Autowired
    private UserAddressRepository addressRepo;

    public List<UserAddressDAO> getAddressWithUserId(String  userId){
        return addressRepo.getAddressesWithUserID(userId);
    }
    public List<UserAddressDAO> upsertUserAddress(List<UserAddressDAO> userAddress){
        return addressRepo.saveAll(userAddress);
    }
}
