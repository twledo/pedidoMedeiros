package dev.medeiros.sitePedidos.controller.endpointPublic;

import dev.medeiros.sitePedidos.model.Order;
import dev.medeiros.sitePedidos.service.interfaces.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/orders")
public class OrderControllerPublic {

    @Autowired
    private OrderService orderService;

    /**
     * Cria um novo pedido enviado pelo cliente via canal público.
     *
     * O objeto {@link Order} recebido no corpo da requisição deve conter os IDs das entidades relacionadas
     * (como sabor, tamanho, bebida, etc) já populados corretamente.
     *
     * Exemplo de JSON de entrada:
     * {
     *   "phoneNumber": "11999999999",
     *   "size": { "id": 2 },
     *   "flavors": [ { "id": 1 }, { "id": 3 } ],
     *   "border": { "id": 1 },
     *   "drink": { "id": 4 },
     *   "observations": "Sem cebola"
     * }
     *
     * @param order entidade {@link Order} enviada pelo cliente
     * @return o pedido salvo com ID gerado e timestamp
     */
    @PostMapping
    public ResponseEntity<Order> create(@Valid @RequestBody Order order) {
        Order saved = orderService.save(order);
        return ResponseEntity.ok(saved);
    }
}
