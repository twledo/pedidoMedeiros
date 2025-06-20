package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Order;
import dev.medeiros.sitePedidos.service.interfaces.WhatsAppService;
import org.springframework.stereotype.Service;

/**
 * Implementação do serviço de envio de notificações via WhatsApp.
 * Neste ponto, a integração com a API de terceiros deve ser realizada.
 */
@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    /**
     * Envia uma mensagem de confirmação de pedido via WhatsApp para o número informado no pedido.
     *
     * @param order objeto {@link Order} contendo os dados do cliente e do pedido
     */
    @Override
    public void notifyNewOrder(Order order) {
        String phoneNumber = order.getNumberPhone();
        String message = "✅ Olá! Seu pedido #" + order.getId() + " foi recebido com sucesso. Em breve entraremos em contato!";

        // Exemplo fictício: chamada à API externa aqui
        // whatsappApiClient.sendMessage(phoneNumber, message);

        System.out.println("Simulação: Enviando mensagem para " + phoneNumber + ": " + message);
    }
}
