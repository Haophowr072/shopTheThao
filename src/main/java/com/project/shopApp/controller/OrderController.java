package com.project.shopApp.controller;

import com.project.shopApp.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/oders")
public class OrderController {

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOderByUserId(@Valid @PathVariable String user_id){
        return ResponseEntity.ok("Lấy danh danh oder của userId: " + user_id);
    }



    @PostMapping("")
    public ResponseEntity<?> createOder(@Valid @RequestBody OrderDTO oderDTO){
        return ResponseEntity.ok("Đặt hàng thành công");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOder(
            @Valid @RequestBody OrderDTO oderDTO,
            @PathVariable String id
    ){
        return ResponseEntity.ok("Sửa đơn đặt hàng thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOder(@Valid @PathVariable String id){
        return ResponseEntity.ok("Xóa đơn hàng thành công");
    }
}
