package com.project.shopApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopApp.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    private String id;

    private String fullname;

    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    private String address;

    private String password;

    @JoinColumn(name = "date_of_birth")
    private Date dateOfBirth;

    @JoinColumn(name = "facebook_account_id")
    private int facebookAccountId;

    @JoinColumn(name = "google_account_id")
    private int googleAccountId;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role roleId;
}
