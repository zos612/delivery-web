package com.example.deliveryweb.dto;

import java.util.List;

public record CartItemDTO(Long userId, List<Long> menuIds, Integer quantity) {}
