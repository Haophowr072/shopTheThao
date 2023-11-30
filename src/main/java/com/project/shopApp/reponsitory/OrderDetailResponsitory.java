package com.project.shopApp.reponsitory;

import com.project.shopApp.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailResponsitory extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOderId(String orderId);
}
