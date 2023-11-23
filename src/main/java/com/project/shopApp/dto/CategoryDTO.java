package com.project.shopApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
    private String id;
    @NotBlank(message = "Vui lòng nhập tên ")
    private String name;
}
