package com.abw12.absolutefitness.usermgmt.service;

import com.abw12.absolutefitness.usermgmt.dto.UserInfoDTO;
import com.abw12.absolutefitness.usermgmt.entity.UserAdminInfoDAO;
import com.abw12.absolutefitness.usermgmt.mappers.GenericMapper;
import com.abw12.absolutefitness.usermgmt.repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMgmtAdminService {

    @Autowired
    private UserAdminRepository userAdminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GenericMapper<UserAdminInfoDAO,UserInfoDTO> mapUserInfoToUserInfoDTO;

    @Autowired
    private GenericMapper<UserInfoDTO, UserAdminInfoDAO> mapUserInfoDTOToUserInfo;

    public UserInfoDTO getUserByName(String userName) {
        Optional<UserAdminInfoDAO> userInfo = userAdminRepository.findByName(userName);
        return userInfo.map((user -> mapUserInfoToUserInfoDTO.mapTo(userInfo.get(),UserInfoDTO.class)))
                .orElseThrow(() -> new RuntimeException("User not found in DB"));
    }

    public String addUser(UserInfoDTO userInfoDTO){
        UserAdminInfoDAO userAdminInfoDAO = mapUserInfoDTOToUserInfo.mapTo(userInfoDTO, UserAdminInfoDAO.class);
        userAdminInfoDAO.setPassword(passwordEncoder.encode(userAdminInfoDAO.getPassword()));
        userAdminRepository.save(userAdminInfoDAO);
         return "User added to DB";
    }
}
