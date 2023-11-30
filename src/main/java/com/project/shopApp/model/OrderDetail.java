package com.project.shopApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetail {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;

    private float price;

    @JoinColumn(name = "number_of_products")
    private int numberOfProduct;

    @JoinColumn(name = "total_money")
    private float totalMoney;

    private String color;
}
