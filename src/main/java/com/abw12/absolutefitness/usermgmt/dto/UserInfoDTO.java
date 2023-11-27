package com.abw12.absolutefitness.usermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    private String userName;
    private String password;
    private String role;
    private Long phnNumber;
    private String emailId;

}
