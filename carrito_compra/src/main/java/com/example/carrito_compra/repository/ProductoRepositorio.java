package com.example.carrito_compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carrito_compra.entity.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
