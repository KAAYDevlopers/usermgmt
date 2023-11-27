package com.abw12.absolutefitness.usermgmt.repository;

import com.abw12.absolutefitness.usermgmt.entity.UserAddressDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressDAO,String> {

    @Query("SELECT a FROM UserAddressDAO a WHERE a.userId =:userId")
    List<UserAddressDAO> getAddressesWithUserID(String userId);

}
