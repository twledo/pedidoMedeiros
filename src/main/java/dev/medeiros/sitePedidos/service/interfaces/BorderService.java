package dev.medeiros.sitePedidos.service.interfaces;

import dev.medeiros.sitePedidos.model.Border;
import java.util.List;

public interface BorderService {

    /**
     * Salva uma nova borda.
     *
     * @param border borda a ser salva
     * @return borda salva
     */
    Border save(Border border);

    /**
     * Lista todas as bordas cadastradas.
     *
     * @return lista de bordas
     */
    List<Border> findAll();

    /**
     * Busca uma borda pelo ID.
     *
     * @param id identificador da borda
     * @return borda encontrada
     */
    Border findById(Long id);

    /**
     * Atualiza uma borda existente.
     *
     * @param id identificador da borda
     * @param border dados atualizados
     * @return borda editada
     */
    Border edit(Long id, Border border);

    /**
     * Remove uma borda com base no ID.
     *
     * @param id identificador da borda
     */
    void deleteById(Long id);
}
