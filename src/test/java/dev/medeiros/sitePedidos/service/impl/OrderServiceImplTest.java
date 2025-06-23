package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Order;
import dev.medeiros.sitePedidos.model.SizePizza;
import dev.medeiros.sitePedidos.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    /**
     * Testa se o metodo save calcula o preço total e salva o pedido.
     *
     * @see OrderServiceImpl#save(Order)
     */
    @Test
    void saveCalculatesTotalPriceAndSavesOrder() {
        Order order = new Order();
        SizePizza size = new SizePizza();
        size.setPrice(100L);
        order.setSizePizza(size);
        order.setDeliveryPrice(50L);

        Order savedOrder = new Order();
        savedOrder.setTotalPrice(150L);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        Order result = orderService.save(order);

        assertEquals(150L, result.getTotalPrice());
        verify(orderRepository).save(order);
    }

    /**
     * Testa se o metodo findAll retorna a lista de pedidos corretamente.
     *
     * @see OrderServiceImpl#findAll()
     */
    @Test
    void findAllReturnsListOfOrders() {
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.findAll();

        assertEquals(2, result.size());
        assertEquals(orders, result);
    }

    /**
     * Testa se o metodo findById retorna o pedido quando ele existe.
     *
     * @see OrderServiceImpl#findById(Long)
     */
    @Test
    void findByIdReturnsOrderWhenExists() {
        Order order = new Order();
        order.setId(1L);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order result = orderService.findById(1L);

        assertEquals(order, result);
    }

    /**
     * Testa se o metodo findById lança exceção quando o pedido não é encontrado.
     *
     * @see OrderServiceImpl#findById(Long)
     */
    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(IllegalArgumentException.class, () -> orderService.findById(99L));
        assertTrue(ex.getMessage().contains("Pedido não encontrado com ID: 99"));
    }

    /**
     * Testa se o metodo deleteById remove o pedido quando ele existe.
     *
     * @see OrderServiceImpl#deleteById(Long)
     */
    @Test
    void deleteByIdDeletesWhenExists() {
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        orderService.deleteById(1L);

        verify(orderRepository).deleteById(1L);
    }

    /**
     * Testa se o metodo deleteById lança exceção quando o pedido não existe.
     *
     * @see OrderServiceImpl#deleteById(Long)
     */
    @Test
    void deleteByIdThrowsExceptionWhenNotExists() {
        when(orderRepository.existsById(2L)).thenReturn(false);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> orderService.deleteById(2L));
        assertTrue(ex.getMessage().contains("Não existe pedido com ID: 2"));
    }
}