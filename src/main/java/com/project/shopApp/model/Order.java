package com.project.shopApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private User user;

    @JsonProperty("fullname")
    private String fullName;

    private String email;

    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    private String address;

    private String note;

    @JoinColumn(name = "order_date")
    private LocalDateTime orderDate;

    private String status;

    @JoinColumn(name = "total_money")
    private Integer totalMoney;

    @JoinColumn(name = "shipping_method")
    private String shippingMethod;

    @JoinColumn(name = "shipping_address")
    private String shippingAddress;

    @JoinColumn(name = "shipping_date")
    private Date shippingDate;

    @JoinColumn(name = "tracking_number")
    private String trackingNumber;

    @JoinColumn(name = "payment_method")
    private String paymentMethod;

    private Boolean active;
}
