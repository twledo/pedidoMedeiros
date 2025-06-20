package dev.medeiros.sitePedidos.service.interfaces;

import dev.medeiros.sitePedidos.model.SizePizza;
import java.util.List;

public interface SizePizzaService {

    /**
     * Salva um novo tamanho de pizza.
     *
     * @param sizePizza tamanho a ser salvo
     * @return tamanho salvo
     */
    SizePizza save(SizePizza sizePizza);

    /**
     * Lista todos os tamanhos disponíveis.
     *
     * @return lista de tamanhos
     */
    List<SizePizza> findAll();

    /**
     * Busca um tamanho específico pelo ID.
     *
     * @param id identificador do tamanho
     * @return tamanho encontrado
     */
    SizePizza findById(Long id);

    /**
     * Atualiza um tamanho de pizza existente.
     *
     * @param id identificador do tamanho
     * @param sizePizza dados atualizados
     * @return tamanho editado
     */
    SizePizza edit(Long id, SizePizza sizePizza);

    /**
     * Exclui um tamanho de pizza com base no ID.
     *
     * @param id identificador do tamanho
     */
    void deleteById(Long id);
}
