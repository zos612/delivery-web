package com.example.deliveryweb.controller;

import com.example.deliveryweb.dto.CartItemDTO;
import com.example.deliveryweb.entity.Cart;
import com.example.deliveryweb.entity.CartItem;
import com.example.deliveryweb.entity.Menu;
import com.example.deliveryweb.entity.User;
import com.example.deliveryweb.repository.CartItemRepository;
import com.example.deliveryweb.repository.CartRepository;
import com.example.deliveryweb.repository.MenuRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class CartController {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MenuRepository menuRepository;

    public CartController(CartRepository cartRepository, CartItemRepository cartItemRepository, MenuRepository menuRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.menuRepository = menuRepository;
    }

    @PostMapping("/cart")
    public ResponseEntity<String> addToCart(@Valid @RequestBody CartItemDTO cartItemDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("장바구니 담기에 실패 했습니다.");
        }

        Cart cart = cartRepository.findByUserId(cartItemDTO.userId());

        //cart가 없는 경우 cart 세팅
        if(cart == null){
            cart = new Cart();
            User user = new User();
            user.setId(cartItemDTO.userId());
            cart.setUser(user);
        }
        Set<CartItem> cartItemToAdd = new HashSet<>();

        //menu id로 cartItem 초회 후 cart에 추가
        for (Long menuId : cartItemDTO.menuIds()) {
            Menu menu = menuRepository.findById(menuId).orElse(null);
            if(menu == null){
                return ResponseEntity.badRequest().body("존재하지 않는 메뉴입니다.");
            }
            CartItem cartItem = new CartItem();
            cartItem.setMenu(menu);
            cartItem.addCart(cart);
            cartItem.setQuantity(cartItemDTO.quantity());
            cartItem.setPrice(menu.getPrice() * cartItemDTO.quantity());

            cartItemToAdd.add(cartItem);
        }

        cart.getCartItems().addAll(cartItemToAdd);
        cartRepository.saveAndFlush(cart);


        return ResponseEntity.ok("장바구니 담기에 성공 했습니다.");
    }
}
