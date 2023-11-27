package com.abw12.absolutefitness.usermgmt.service;

import com.abw12.absolutefitness.usermgmt.dto.UserAddressDTO;
import com.abw12.absolutefitness.usermgmt.dto.UserDataDTO;
import com.abw12.absolutefitness.usermgmt.entity.UserAddressDAO;
import com.abw12.absolutefitness.usermgmt.entity.UserDataDAO;
import com.abw12.absolutefitness.usermgmt.mappers.UserAddressMapper;
import com.abw12.absolutefitness.usermgmt.mappers.UserDataMapper;
import com.abw12.absolutefitness.usermgmt.persistence.UserAddressPersistenceLayer;
import com.abw12.absolutefitness.usermgmt.persistence.UserDataPersistenceLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMgmtService {

    @Autowired
    private UserDataPersistenceLayer userDataPersistenceLayer;
    @Autowired
    private UserAddressPersistenceLayer userAddressPersistenceLayer;
    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserMgmtService.class);

    public UserDataDTO getUser(String userId) {
        logger.info("Inside getUser method.");
        UserDataDTO response = userDataMapper.entityToDto(userDataPersistenceLayer.getUser(userId));
        logger.debug("User Data fetched with userId: {} = {}",userId,response);
        List<UserAddressDTO> addressList = userAddressPersistenceLayer.getAddressWithUserId(userId).stream()
                .map(userAddressDAO ->
                        userAddressMapper.entityToDTO(userAddressDAO)
                ).toList();
        logger.debug("User Addresses fetched with userId: {} => {}",userId,addressList);
        response.setUserAddresses(addressList);
        logger.info("Successfully fetched user data.");
        return response;
    }

    public UserDataDTO upsertUserData(UserDataDTO userDataDTO) {
        logger.info("Inside addUser method.");
        if(userDataDTO == null) throw new RuntimeException("User data object is Null");

        logger.debug("Upsert User data : {}",userDataDTO);
        UserDataDAO userData = userDataMapper.DtoToEntity(userDataDTO);
        UserDataDTO response = userDataMapper.entityToDto(userDataPersistenceLayer.upsertUserData(userData));
        String userId = response.getUserId();
        List<UserAddressDAO> userAddressList = userDataDTO.getUserAddresses().stream()
                .map(userAddressDTO -> {
                    userAddressDTO.setUserId(userId);
                    logger.debug("adding address : {} for user with userId : {}",userAddressDTO,userId);
                    return userAddressMapper.DtoToEntity(userAddressDTO);
                })
                .toList();

        List<UserAddressDTO> storedUserAddresses = userAddressPersistenceLayer.upsertUserAddress(userAddressList).stream()
                .map(userAddressDAO -> userAddressMapper.entityToDTO(userAddressDAO))
                .toList();
        response.setUserAddresses(storedUserAddresses);
        logger.info("successfully added user data in db ");
        return response;
    }

    public List<UserAddressDTO> saveUserAddresses(String userId,List<UserAddressDTO> userAddresses) {
        logger.info("Inside saveUserAddresses method.");
        List<UserAddressDAO> addressList = userAddresses.stream()
                .map(addressData -> {
                    addressData.setUserId(userId);
                    return userAddressMapper.DtoToEntity(addressData);
                })
                .toList();
        List<UserAddressDTO> response = userAddressPersistenceLayer.upsertUserAddress(addressList).stream()
                .map(userAddressDAO -> userAddressMapper.entityToDTO(userAddressDAO))
                .toList();
        logger.debug("Address list stored in db : {}", response);
        logger.info("Successfully saved user addresses data");
        return response;
    }
}
