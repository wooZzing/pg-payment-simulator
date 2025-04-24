package com.pg.merchantserver.domain.order.service;

import com.pg.merchantserver.domain.order.dto.OrderCreateRequest;
import com.pg.merchantserver.domain.order.entity.Order;
import com.pg.merchantserver.domain.order.repository.OrderRepository;
import com.pg.merchantserver.domain.product.entity.Product;
import com.pg.merchantserver.domain.product.repository.ProductRepository;
import com.pg.merchantserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Order createOrder(OrderCreateRequest request) {
        // 사용자 존재 여부 확인
        userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않습니다"));

        // 상품 조회 및 금액 계산
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("상품이 존재하지 않습니다"));

        int totalAmount = product.getPrice() * request.getQuantity();

        return orderRepository.save(Order.builder()
                .userId(request.getUserId())
                .productId(request.getProductId())
                .amount(totalAmount)
                .status("CREATED")
                .build());
    }
}