package com.example.carrito_compra.repository;

import com.example.carrito_compra.entity.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ItemCarritoRepositorio extends JpaRepository<ItemCarrito, Long> {
    
    List<ItemCarrito> findBySessionId(String sessionId);
    
    Optional<ItemCarrito> findBySessionIdAndProductId(String sessionId, Long productId);
    
    void deleteBySessionIdAndProductId(String sessionId, Long productId);
    
    void deleteBySessionId(String sessionId);
}
