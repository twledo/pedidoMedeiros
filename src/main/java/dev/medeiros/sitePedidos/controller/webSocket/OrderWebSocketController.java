package dev.medeiros.sitePedidos.controller.webSocket;

import dev.medeiros.sitePedidos.model.Order;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class OrderWebSocketController {

    @MessageMapping("/order")
    @SendTo("/topic/orders")
    public Order sendOrder(Order order) {
        return order;
    }
}