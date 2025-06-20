package dev.medeiros.sitePedidos.model;

import dev.medeiros.sitePedidos.enums.DeliveryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Representa um pedido de pizza realizado por um cliente.
 * Contém informações sobre endereço, tamanho da pizza, borda, sabores, bebida e preços.
 *
 * <p>O preço total é calculado a partir do tamanho da pizza e valor da entrega.</p>
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    /**
     * Identificador único do pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Endereço de entrega do pedido.
     */
    private String address;

    /**
     * Tamanho da pizza escolhido.
     */
    @ManyToOne
    @JoinColumn(name = "size_id")
    private SizePizza sizePizza;

    /**
     * Tipo de borda da pizza.
     */
    @ManyToOne
    @JoinColumn(name = "border_id")
    private Border border;

    /**
     * Lista de sabores selecionados para a pizza.
     */
    @ManyToMany
    @JoinTable(
            name = "order_flavors",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "flavor_id")
    )
    private List<Flavor> flavorsPizza;

    /**
     * Bebida escolhida no pedido.
     */
    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    /**
     * Valor da entrega em centavos (ex: 500 = R$ 5,00).
     */
    private Long deliveryPrice;

    /**
     * Preço total do pedido em centavos, calculado como
     * tamanho da pizza + valor da entrega.
     */
    private Long totalPrice;

    /**
     * Indica se o pedido será retirado no local (true) ou entregue (false).
     */
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

}
