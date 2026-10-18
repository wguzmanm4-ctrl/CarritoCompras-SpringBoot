package com.example.carrito_compra.service;

import java.util.List;
import com.example.carrito_compra.entity.*;

public interface TiendaServicio {
  // Products
  List<Producto> findAllProducts();
  Producto createProduct(Producto p);
  Producto getProduct(Long id);

  // Cart
  List<ItemCarrito> getCart(String sessionId);
  void addToCart(String sessionId, Long productId, int qty);
  void removeFromCart(String sessionId, Long productId);
  double total(String sessionId);
  void clearCart(String sessionId);
}
