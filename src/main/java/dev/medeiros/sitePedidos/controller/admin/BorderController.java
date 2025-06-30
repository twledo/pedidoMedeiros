package dev.medeiros.sitePedidos.controller.admin;

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

    @GetMapping
    public ResponseEntity<List<Border>> findAll() {
        try {
            return ResponseEntity.ok(borderService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    /**
     * Retorna uma borda específica pelo ID.
     *
     * @param id identificador da borda
     * @return {@link ResponseEntity} contendo a {@link Border} ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Border> getBorderById(@PathVariable Long id) {
        try {
            Border border = borderService.findById(id);
            return ResponseEntity.ok(border);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
