package dev.medeiros.sitePedidos.controller;

import dev.medeiros.sitePedidos.model.Border;
import dev.medeiros.sitePedidos.service.interfaces.BorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar as bordas das pizzas.
 */
@RestController
@RequestMapping("/admin/borders")
public class BorderController {

    @Autowired
    private BorderService borderService;

    /**
     * Cria uma nova borda.
     *
     * @param border objeto a ser salvo
     * @return borda salva
     */
    @PostMapping
    public ResponseEntity<Border> create(@RequestBody Border border) {
        return ResponseEntity.ok(borderService.save(border));
    }

    /**
     * Atualiza uma borda existente.
     *
     * @param id identificador da borda
     * @param border dados atualizados
     * @return borda atualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Border> update(@PathVariable Long id, @RequestBody Border border) {
        return ResponseEntity.ok(borderService.edit(id, border));
    }

    /**
     * Exclui uma borda pelo ID.
     *
     * @param id identificador da borda
     * @return resposta sem conteúdo
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        borderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
