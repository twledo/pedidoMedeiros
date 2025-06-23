package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Order;
import dev.medeiros.sitePedidos.repository.OrderRepository;
import dev.medeiros.sitePedidos.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Implementação do serviço de pedidos.
 * Responsável por gerenciar operações de CRUD e cálculo de preço total.
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    /**
     * Salva ou atualiza um pedido.
     * Calcula automaticamente o preço total com base no tamanho da pizza e valor da entrega.
     *
     * @param order pedido a ser salvo
     * @return pedido persistido
     */
    @Override
    public Order save(Order order) {
        logger.info("Salvando pedido: {}", order);
        long sizePrice = order.getSizePizza() != null ? order.getSizePizza().getPrice() : 0L;
        long deliveryPrice = order.getDeliveryPrice() != null ? order.getDeliveryPrice() : 0L;

        order.setTotalPrice(sizePrice + deliveryPrice);
        return orderRepository.save(order);
    }

    /**
     * Retorna todos os pedidos cadastrados.
     *
     * @return lista de pedidos
     */
    @Override
    public List<Order> findAll() {
        logger.info("Buscando todos os pedidos");
        return orderRepository.findAll();
    }

    /**
     * Busca um pedido pelo ID fornecido.
     *
     * @param id identificador do pedido
     * @return pedido encontrado
     * @throws IllegalArgumentException se não existir pedido com o ID
     */
    @Override
    public Order findById(Long id) {
        logger.info("Buscando pedido por ID: {}", id);
        return orderRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Pedido não encontrado com ID: {}", id);
                    return new IllegalArgumentException("Pedido não encontrado com ID: " + id);
                });
    }

    /**
     * Exclui um pedido com base no ID.
     *
     * @param id identificador do pedido
     * @throws IllegalArgumentException se o pedido não existir
     */
    @Override
    public void deleteById(Long id) {
        logger.info("Deletando pedido ID: {}", id);
        if (!orderRepository.existsById(id)) {
            logger.warn("Tentativa de deletar pedido inexistente ID: {}", id);
            throw new IllegalArgumentException("Não existe pedido com ID: " + id);
        }
        orderRepository.deleteById(id);
    }
}
