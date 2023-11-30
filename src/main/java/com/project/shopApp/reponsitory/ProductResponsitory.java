package com.project.shopApp.reponsitory;

import com.project.shopApp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductResponsitory extends JpaRepository<Product, String> {
    boolean existsByName(String name);

    Page<Product> findAll(Pageable pageable);// phân trang
}
