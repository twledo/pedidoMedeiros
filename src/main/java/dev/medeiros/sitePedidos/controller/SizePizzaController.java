package dev.medeiros.sitePedidos.controller;

import dev.medeiros.sitePedidos.model.SizePizza;
import dev.medeiros.sitePedidos.service.interfaces.SizePizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar os tamanhos de pizza disponíveis.
 * Fornece endpoints para operações de criação, consulta, edição e exclusão.
 */
@RestController
@RequestMapping("/admin/sizes")
public class SizePizzaController {

    @Autowired
    private SizePizzaService sizePizzaService;

    /**
     * Cria um novo tamanho de pizza.
     *
     * @param sizePizza objeto {@link SizePizza} a ser criado
     * @return {@link ResponseEntity} com o objeto salvo
     */
    @PostMapping
    public ResponseEntity<SizePizza> createSize(@RequestBody SizePizza sizePizza) {
        return ResponseEntity.ok(sizePizzaService.save(sizePizza));
    }

    /**
     * Lista todos os tamanhos de pizza cadastrados.
     *
     * @return lista de {@link SizePizza}
     */
    @GetMapping
    public List<SizePizza> getAllSizes() {
        return sizePizzaService.findAll();
    }

    /**
     * Recupera um tamanho de pizza com base no ID informado.
     *
     * @param id identificador do tamanho
     * @return {@link ResponseEntity} com o tamanho ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<SizePizza> getSizeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(sizePizzaService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Atualiza um tamanho de pizza existente.
     *
     * @param id identificador do tamanho
     * @param sizePizza dados atualizados do tamanho
     * @return {@link ResponseEntity} com o tamanho atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<SizePizza> updateSize(@PathVariable Long id, @RequestBody SizePizza sizePizza) {
        try {
            return ResponseEntity.ok(sizePizzaService.edit(id, sizePizza));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um tamanho de pizza com base no ID.
     *
     * @param id identificador do tamanho
     * @return {@link ResponseEntity} com status 204 ou 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSize(@PathVariable Long id) {
        try {
            sizePizzaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
