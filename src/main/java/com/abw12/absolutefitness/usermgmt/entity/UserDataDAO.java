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
@Table(name = "userdata" ,schema = "usermgmt")
public class UserDataDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "user_created_at")
    private OffsetDateTime userCreatedAt;
    @Column(name = "user_modified_at")
    private OffsetDateTime userModifiedAt;
}
