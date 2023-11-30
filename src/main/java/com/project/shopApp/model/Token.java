package com.project.shopApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tokens")
public class Token {
    @Id
    private String id;

    private String token;

    @JoinColumn(name = "token_type")
    private String tokenType;

    @JoinColumn(name = "expiration_date")
    private LocalDateTime expirationDate;

    private boolean revoked;
    private boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
