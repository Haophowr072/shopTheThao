package com.project.shopApp.reponsitory;

import com.project.shopApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OederResponsitory extends JpaRepository<Order, String> {
    // tìm 1 đơn hàng của user nào đó
    List<Order> findByUserid(String userId);
}
