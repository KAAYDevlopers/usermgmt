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
@Table(name = "address" , schema = "usermgmt")
public class UserAddressDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "address_line")
    private String addressLine;
    @Column(name = "locality_area")
    private String localityArea;
    private String landmark;
    @Column(name = "pin_code")
    private Integer pinCode;
    private String city;
    @Column(name = "state_name")
    private String state;
    @Column(name = "address_created_at")
    private OffsetDateTime addressCreatedAt;
    @Column(name = "address_modified_at")
    private OffsetDateTime addressModifiedAt;

}
