package dev.medeiros.sitePedidos.service.interfaces;

import dev.medeiros.sitePedidos.model.Flavor;
import java.util.List;

public interface FlavorService {

    /**
     * Salva um novo sabor.
     *
     * @param flavor sabor a ser salvo
     * @return sabor salvo
     */
    Flavor save(Flavor flavor);

    /**
     * Lista todos os sabores disponíveis.
     *
     * @return lista de sabores
     */
    List<Flavor> findAll();

    /**
     * Busca um sabor pelo ID.
     *
     * @param id identificador do sabor
     * @return sabor encontrado
     */
    Flavor findById(Long id);

    /**
     * Atualiza um sabor existente.
     *
     * @param id identificador do sabor a ser atualizado
     * @param flavor dados atualizados
     * @return sabor editado
     */
    Flavor edit(Long id, Flavor flavor);

    /**
     * Remove um sabor pelo ID.
     *
     * @param id identificador do sabor
     */
    void deleteById(Long id);
}
