package dev.medeiros.sitePedidos.model;

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
}
