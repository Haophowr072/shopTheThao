package com.project.shopApp.model;

import com.project.shopApp.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    private String id;
    private String name;
    private float price;
    private String thumbnail;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
