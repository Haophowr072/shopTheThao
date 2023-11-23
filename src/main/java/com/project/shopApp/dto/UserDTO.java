package com.project.shopApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    private String id;

    @NotBlank(message = "Vui lòng nhập tên vào")
    private String fullname;

    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @JsonProperty("phone_number")
    private String phoneNumber;

    private String address;

    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String password;

    @JsonProperty("retype_password")
    @NotBlank(message = "Nhập lại mật khẩu")
    private String retypePassword;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("facebook_account_id")
    private int facebookAccountId;

    @JsonProperty("google_account_id")
    private int googleAccountId;

    @NotBlank(message = "Thiếu role ID")
    @JsonProperty("role_id")
    private String roleId;
}
