package com.project.shopApp.controller;

import com.project.shopApp.dto.OrderDTO;
import com.project.shopApp.dto.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/oder_details")
public class OrderDetailController {

    @GetMapping("{id}")
    public ResponseEntity<?> getOderById(@Valid @PathVariable String id){
        return ResponseEntity.ok("Lấy danh danh oder của Id: " + id);
    }
    @GetMapping("/order/{user_id}")
    public ResponseEntity<?> getOderByUserId(@Valid @PathVariable String user_id){
        return ResponseEntity.ok("Lấy danh danh oder của userId: " + user_id);
    }

    @PostMapping("")
    public ResponseEntity<?> createOderDetail(@Valid @RequestBody OrderDetailDTO newOrderDetail){
        return ResponseEntity.ok("Chi tiết đơn đặt hàng");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTO,
            @PathVariable String id
    ){
        return ResponseEntity.ok("Sửa chi tiết đơn đặt hàng thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOderDetail(@Valid @PathVariable String id){
        return ResponseEntity.ok("Xóa đơn hàng thành công");
    }
}
