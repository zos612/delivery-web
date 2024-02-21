package com.example.deliveryweb.controller;

import com.example.deliveryweb.dto.CartItemDTO;
import com.example.deliveryweb.entity.CartItem;
import com.example.deliveryweb.repository.CartRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping("/cart")
    public ResponseEntity<String> AddToCart(@Valid @RequestBody CartItemDTO cartItemDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("장바구니 담기에 실패 했습니다.");
        }
//        cartRepository.save(cartItem);

        return ResponseEntity.ok("장바구니 담기에 성공 했습니다.");
    }
}
