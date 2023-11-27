package com.abw12.absolutefitness.usermgmt.controller;

import com.abw12.absolutefitness.usermgmt.dto.UserAddressDTO;
import com.abw12.absolutefitness.usermgmt.dto.UserDataDTO;
import com.abw12.absolutefitness.usermgmt.service.UserMgmtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermgmt")
public class UserMgmtController {

    @Autowired
    private UserMgmtService userMgmtService;

    @GetMapping("/{userId}")
    private ResponseEntity<UserDataDTO> getUserByName(@PathVariable String userId){
        return new ResponseEntity<>(userMgmtService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    private ResponseEntity<UserDataDTO> upsertUserData(@RequestBody @Valid UserDataDTO userDataDTO){
        return new ResponseEntity<>(userMgmtService.upsertUserData(userDataDTO),HttpStatus.OK);
    }

    @PostMapping("/saveAddress/{userId}")
    private ResponseEntity<List<UserAddressDTO>> saveUserAddressesWithUserId(@RequestBody @Valid List<UserAddressDTO> userAddresses,
                                                                             @PathVariable String userId){
        return new ResponseEntity<>(userMgmtService.saveUserAddresses(userId,userAddresses),HttpStatus.OK);
    }

}
