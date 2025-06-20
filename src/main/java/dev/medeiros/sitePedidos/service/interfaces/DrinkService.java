package dev.medeiros.sitePedidos.service.interfaces;

import dev.medeiros.sitePedidos.model.Drink;
import java.util.List;

public interface DrinkService {

    /**
     * Salva uma nova bebida.
     *
     * @param drink bebida a ser salva
     * @return bebida salva
     */
    Drink save(Drink drink);

    /**
     * Retorna todas as bebidas disponíveis.
     *
     * @return lista de bebidas
     */
    List<Drink> findAll();

    /**
     * Busca uma bebida pelo ID.
     *
     * @param id identificador da bebida
     * @return bebida encontrada
     */
    Drink findById(Long id);

    /**
     * Atualiza uma bebida existente.
     *
     * @param id identificador da bebida
     * @param drink dados atualizados
     * @return bebida editada
     */
    Drink edit(Long id, Drink drink);

    /**
     * Exclui uma bebida com base no ID.
     *
     * @param id identificador da bebida
     */
    void deleteById(Long id);
}
