package com.example.carrito_compra.service;

import com.example.carrito_compra.entity.Producto;
import com.example.carrito_compra.entity.ItemCarrito;
import com.example.carrito_compra.repository.ProductoRepositorio;
import com.example.carrito_compra.repository.ItemCarritoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TiendaServicioTest {

    @Mock
    private ProductoRepositorio productRepository;

    @Mock
    private ItemCarritoRepositorio cartItemRepository;

    @InjectMocks
    private TiendaServicioImpl shopService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Producto productoFalso = Producto.builder()
                .id(1L)
                .name("Tasa de prueba")
                .price(50.0)
                .build();

        when(productRepository.save(any(Producto.class))).thenReturn(productoFalso);

        Producto resultado = shopService.createProduct(productoFalso);

        assertNotNull(resultado);
        assertEquals("Tasa de prueba", resultado.getName());
        verify(productRepository, times(1)).save(productoFalso);
    }

    @Test
    void testFindAllProducts() {
        Producto p1 = Producto.builder().id(1L).name("Producto 1").price(10.0).build();
        Producto p2 = Producto.builder().id(2L).name("Producto 2").price(20.0).build();

        when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Producto> lista = shopService.findAllProducts();

        assertEquals(2, lista.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testAddToCart() {
        Producto p1 = Producto.builder().id(1L).name("Producto 1").price(10.0).build();
        when(productRepository.findById(1L)).thenReturn(Optional.of(p1));
        
        when(cartItemRepository.findBySessionIdAndProductId("sesion123", 1L)).thenReturn(Optional.empty());

        shopService.addToCart("sesion123", 1L, 2);

        verify(cartItemRepository, times(1)).save(any(ItemCarrito.class));
    }
}
