package com.project.shopApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {

    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String password;
}
