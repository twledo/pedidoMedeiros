package dev.medeiros.sitePedidos.service.interfaces;

import dev.medeiros.sitePedidos.model.Order;

/**
 * Interface para o serviço de envio de mensagens via WhatsApp.
 * Responsável por definir operações relacionadas a notificações de pedidos.
 */
public interface WhatsAppService {

    /**
     * Envia uma notificação via WhatsApp informando que o pedido foi recebido.
     *
     * @param order objeto {@link Order} com os dados do pedido
     */
    void notifyNewOrder(Order order);
}
