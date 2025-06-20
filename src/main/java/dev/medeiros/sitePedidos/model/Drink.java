package dev.medeiros.sitePedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa uma bebida opcional que pode ser incluída no pedido.
 */
@Entity
@Table(name = "drinks")
@Getter
@Setter
public class Drink {

    /**
     * Identificador único da bebida.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome da bebida (ex: Refrigerante, Suco).
     */
    private String name;

    /**
     * Valor da bebida em centavos, 500 -> R$ 5
     */
    private Long price;
}
