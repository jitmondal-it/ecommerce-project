package com.project.ecommerce_backend.repo;

import com.project.ecommerce_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo  extends JpaRepository<Order,Integer> {

Optional<Order> findByOrderId(String orderId);


}
