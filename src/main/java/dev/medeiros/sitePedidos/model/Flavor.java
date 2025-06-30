package dev.medeiros.sitePedidos.model;

import dev.medeiros.sitePedidos.enums.TypeFlavors;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa um sabor de pizza disponível para seleção.
 */
@Entity
@Table(name = "flavors")
@Getter
@Setter
public class Flavor {

    /**
     * Identificador único do sabor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do sabor da pizza (ex: Calabresa, Quatro Queijos).
     */
    private String name;

    /**
     * Descrição detalhada do sabor da pizza.
     */
    private String description;

    /**
     * Tipo de sabor da pizza para filtro, ex: salgado ou doce
     */
    @Enumerated(EnumType.STRING)
    private TypeFlavors type;
}
