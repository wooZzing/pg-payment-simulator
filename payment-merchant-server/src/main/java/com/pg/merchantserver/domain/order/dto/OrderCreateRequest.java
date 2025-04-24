package com.pg.merchantserver.domain.order.dto;

import lombok.Data;

@Data
public class OrderCreateRequest {
    private Long userId;
    private Long productId;
    private Integer quantity;
}