package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Order;
import com.viniciuselias.projetotcc.model.entities.OrderItem;
import com.viniciuselias.projetotcc.model.entities.Product;

public record OrderItemDTO(Long id, Integer quantity, Double price,
                           Product product , Order order, Double subTotal) {

    public OrderItemDTO(OrderItem orderItem) {
        this(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getPrice(),
                orderItem.getProduct(),
                orderItem.getOrder(),
                orderItem.getSubTotal()
        );
    }
}
