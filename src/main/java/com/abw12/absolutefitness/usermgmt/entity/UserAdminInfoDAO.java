package com.abw12.absolutefitness.usermgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "useradmindata" ,schema = "usermgmt")
public class UserAdminInfoDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_admin_id")
    private String userAdminId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_role")
    private String role ;
    @Column(name = "phone_number")
    private Long phnNumber;
    @Column(name ="email_id")
    private String emailId;
    @Column(name = "user_created_at")
    private OffsetDateTime userCreatedAt;
    @Column(name = "user_modified_at")
    private OffsetDateTime userModifiedAt;


}
