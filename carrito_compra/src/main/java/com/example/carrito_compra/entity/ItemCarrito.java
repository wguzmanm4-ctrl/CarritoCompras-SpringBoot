package com.example.carrito_compra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ItemCarrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;

    private Long productId;
    private String name;
    private Double price;
    private int quantity;

    public Double getSubtotal() {
        return price * quantity;
    }
}
