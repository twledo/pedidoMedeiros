package dev.medeiros.sitePedidos.controller;

import dev.medeiros.sitePedidos.model.Order;
import dev.medeiros.sitePedidos.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável pelo gerenciamento de pedidos de pizza.
 * Fornece endpoints para operações de criação, leitura, atualização e exclusão (CRUD).
 */
@RestController
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * Cria um novo pedido.
     *
     * @param order objeto {@link Order} com os dados do pedido
     * @return {@link ResponseEntity} com o pedido criado
     */
    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    /**
     * Lista todos os pedidos realizados.
     *
     * @return lista de {@link Order}
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    /**
     * Retorna um pedido específico com base no ID.
     *
     * @param id identificador do pedido
     * @return {@link ResponseEntity} contendo o pedido ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(orderService.findById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Atualiza um pedido existente.
     *
     * @param id identificador do pedido
     * @param order objeto {@link Order} com os dados atualizados
     * @return {@link ResponseEntity} com o pedido atualizado ou 404 se não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        try {
            order.setId(id);
            return ResponseEntity.ok(orderService.save(order));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove um pedido com base no ID fornecido.
     *
     * @param id identificador do pedido a ser excluído
     * @return {@link ResponseEntity} com status 204 ou 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
