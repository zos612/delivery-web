package com.example.deliveryweb.repository;

import com.example.deliveryweb.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long > {

    Cart findByUserId(Long userId);

}
