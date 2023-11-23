package com.project.shopApp.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/oders")
public class OderController {
    @PostMapping("")
    public ResponseEntity<?> createOder(@Valid @RequestBody OderDTO oderDTO){
        return ResponseEntity.ok("Đặt hàng thành công");
    }
}
