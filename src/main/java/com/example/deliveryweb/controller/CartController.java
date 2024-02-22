package com.example.deliveryweb.controller;

import com.example.deliveryweb.dto.CartItemDTO;
import com.example.deliveryweb.entity.Cart;
import com.example.deliveryweb.entity.CartItem;
import com.example.deliveryweb.entity.Menu;
import com.example.deliveryweb.entity.User;
import com.example.deliveryweb.repository.CartRepository;
import com.example.deliveryweb.repository.MenuRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;

    public CartController(CartRepository cartRepository, MenuRepository menuRepository) {
        this.cartRepository = cartRepository;
        this.menuRepository = menuRepository;
    }

    @PostMapping("/cart")
    public ResponseEntity<String> AddToCart(@Valid @RequestBody CartItemDTO cartItemDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("장바구니 담기에 실패 했습니다.");
        }

        Cart cart = cartRepository.findByUserId(cartItemDTO.userId());

        if(cart == null){
            cart = new Cart();
            User user = new User();
            user.setId(cartItemDTO.userId());
            cart.setUser(user);
        }

        List<Long> menuIds = cartItemDTO.menuIds();

        for (Long menuId : menuIds) {
            Menu menu = menuRepository.findById(menuId).orElse(null);
            if(menu == null){
                return new ResponseEntity<>("존재하지 않는 메뉴입니다.", HttpStatus.NOT_FOUND);
            }
            CartItem cartItem = new CartItem();
            cartItem.setMenu(menu);
        }

        return ResponseEntity.ok("장바구니 담기에 성공 했습니다.");
    }
}
