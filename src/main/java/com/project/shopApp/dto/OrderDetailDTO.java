package com.project.shopApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderDetailDTO {
    @JsonProperty("order_id")
    private String orderID;

    @JsonProperty("product_id")
    private String productID;

    private float price;

    @JsonProperty("number_of_products")
    private float numberOfProducts;

    @JsonProperty("total_money")
    private float totalMoney;

    private String color;
}
