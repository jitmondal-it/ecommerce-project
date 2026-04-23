package com.project.ecommerce_backend.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(

        String productName,
        int quantity,
        BigDecimal totalPrice
) {
}
