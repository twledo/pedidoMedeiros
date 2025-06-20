package dev.medeiros.sitePedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa o tamanho disponível para a pizza.
 */
@Entity
@Table(name = "sizes")
@Getter
@Setter
public class SizePizza {

    /**
     * Identificador único do tamanho.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do tamanho da pizza, ex: Pequena, Média
     */
    private String name;

    /**
     * Descrição do tamanho da pizza ex: "Pizza com 1 sabor e 8 fatias"
     */
    private String description;

    /**
     * Valor do tamanho de cada pizza em centavos, 8000 -> R$ 80
     */
    private Long price;
}
