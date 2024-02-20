//package com.abw12.absolutefitness.usermgmt.controller;
//
//import com.abw12.absolutefitness.usermgmt.dto.AuthRequest;
//import com.abw12.absolutefitness.usermgmt.dto.UserInfoDTO;
//import com.abw12.absolutefitness.usermgmt.service.JwtService;
//import com.abw12.absolutefitness.usermgmt.service.UserMgmtAdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/usermgmt/admin")
//public class UserMgmtAuthenticationController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtService jwtService;
//    @Autowired
//    private UserMgmtAdminService userMgmtAdminService;
//
//    @PostMapping("/authenticate")
//    private String authenticate(@RequestBody AuthRequest authRequest){
////        UsernamePasswordAuthenticationToken method internally check if the given username and password does exist in the DB or not
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
//        if(authentication.isAuthenticated()){
//            return jwtService.generateToken(authRequest.getUserName());
//        }else{
//            throw new UsernameNotFoundException("invalid user request !");
//        }
//    }
//
//    @GetMapping("/{userName}")
//    private ResponseEntity<UserInfoDTO> getUserByName(@PathVariable String userName){
//        return new ResponseEntity<>(userMgmtAdminService.getUserByName(userName), HttpStatus.OK);
//    }
//
//    @PostMapping("/addUser")
//    private ResponseEntity<String> addUser(@RequestBody UserInfoDTO userInfoDTO){
//        return new ResponseEntity<>(userMgmtAdminService.addUser(userInfoDTO),HttpStatus.CREATED);
//    }
//}
