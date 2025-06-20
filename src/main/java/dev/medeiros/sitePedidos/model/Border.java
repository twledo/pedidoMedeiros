package dev.medeiros.sitePedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa uma borda opcional da pizza, como catupiry ou cheddar.
 */
@Entity
@Table(name = "borders")
@Getter
@Setter
public class Border {

    /**
     * Identificador único da borda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome da borda da pizza.
     */

    private String name;

    /**
     * Valor de cada borda em centavos, 500 -> R$ 5
     */
    private Long price;
}
