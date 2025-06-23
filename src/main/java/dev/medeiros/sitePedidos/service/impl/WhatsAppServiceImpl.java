package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Order;
import dev.medeiros.sitePedidos.service.interfaces.WhatsAppService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementação do serviço de envio de notificações via WhatsApp.
 * Neste ponto, a integração com a API de terceiros deve ser realizada.
 */
@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    private static final Logger logger = LoggerFactory.getLogger(WhatsAppServiceImpl.class);

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

        logger.info("Simulação: Enviando mensagem para {}: {}", phoneNumber, message);
    }
}
