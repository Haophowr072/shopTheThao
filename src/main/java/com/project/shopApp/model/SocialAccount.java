package com.project.shopApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "social_accounts")
public class SocialAccount {
    @Id
    private String id;

    private String provider;

    @JoinColumn(name = "provider_id")
    private String providerID;

    private String email;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
