package com.example.deliveryweb.dto;

public record CartItemDTO(Long userId, Long menuId, Integer quantity, Double price) {}
