package com.viniciuselias.projetotcc.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciuselias.projetotcc.model.dto.OrderItemDTO;
import com.viniciuselias.projetotcc.model.entities.enums.OrderStatus;
import com.viniciuselias.projetotcc.model.entities.exceptions.inputDataException;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
@Getter @Setter
public class OrderItem {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Long id;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(Long id, Integer quantity, Product product, Order order) {
        if(!validateQuantityInStock(quantity, product))
            throw new inputDataException("quantity exceeded. Quantity total in Stock: " + product.getQuantity());
        this.id = id;
        this.quantity = quantity;
        this.price = product.getFinalPrice();
        this.product = product;
        this.order = order;
        alterQuantityInStock();
    }


    public OrderItem(OrderItemDTO orderItemDTO) {
        this.id = orderItemDTO.id();
        this.quantity = orderItemDTO.quantity();
        this.price = orderItemDTO.price();
        this.product = orderItemDTO.product();
        this.order = orderItemDTO.order();

    }

    public Double getSubTotal() {
        return quantity * price;
    }

    private Boolean validateQuantityInStock(Integer quantity, Product product){
        if( quantity < product.getQuantity()){
            return true;
        }
        return false;
    }

    private void alterQuantityInStock() {
        if(order.getOrderStatus() != OrderStatus.CANCELED){
            product.removeProductInStock(getQuantity());
        }
    }
}
