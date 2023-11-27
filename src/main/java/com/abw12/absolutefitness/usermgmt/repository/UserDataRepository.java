package com.abw12.absolutefitness.usermgmt.repository;

import com.abw12.absolutefitness.usermgmt.entity.UserDataDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataDAO,String> {

    @Query("SELECT u FROM UserDataDAO u WHERE u.userId = :userId")
    Optional<UserDataDAO> getUserDataByUserId(@Param("userId") String userId);
}
