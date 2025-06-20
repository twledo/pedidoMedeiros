package dev.medeiros.sitePedidos.service.interfaces;

import dev.medeiros.sitePedidos.model.Order;
import java.util.List;

public interface OrderService {

    /**
     * Salva ou atualiza um pedido.
     *
     * @param order pedido a ser salvo
     * @return pedido salvo
     */
    Order save(Order order);

    /**
     * Retorna todos os pedidos cadastrados.
     *
     * @return lista de pedidos
     */
    List<Order> findAll();

    /**
     * Busca um pedido pelo ID.
     *
     * @param id identificador do pedido
     * @return pedido encontrado
     */
    Order findById(Long id);

    /**
     * Exclui um pedido com base no ID.
     *
     * @param id identificador do pedido
     */
    void deleteById(Long id);
}
