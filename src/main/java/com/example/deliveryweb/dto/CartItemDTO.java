package com.example.deliveryweb.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    Long userId;
    List<Long> menuIds;
    Integer quantity;
}
