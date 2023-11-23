package com.project.shopApp.controller;

import com.project.shopApp.dto.UserDTO;
import com.project.shopApp.dto.UserLoginDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){
        if(!userDTO.getPassword().equals(userDTO.getRetypePassword())){
            ResponseEntity.badRequest().body("Nhập lại mật khẩu không đúng");
        }
        return ResponseEntity.ok("Đăng ký thành công");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO){

        return ResponseEntity.ok("Đăng nhập thành công");
    }
}
