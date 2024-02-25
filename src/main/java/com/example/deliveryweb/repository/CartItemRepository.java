package com.example.deliveryweb.repository;

import com.example.deliveryweb.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
