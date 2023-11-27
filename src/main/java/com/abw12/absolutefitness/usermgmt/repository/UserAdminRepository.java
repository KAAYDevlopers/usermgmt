package com.abw12.absolutefitness.usermgmt.repository;

import com.abw12.absolutefitness.usermgmt.entity.UserAdminInfoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdminInfoDAO,String> {

    @Query("SELECT u FROM UserAdminInfoDAO u WHERE u.userName=:userName")
    Optional<UserAdminInfoDAO> findByName(String userName);
}
