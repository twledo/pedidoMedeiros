package dev.medeiros.sitePedidos.controller.admin;

import dev.medeiros.sitePedidos.model.Flavor;
import dev.medeiros.sitePedidos.service.interfaces.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar os sabores de pizza.
 * Fornece endpoints para operações CRUD.
 */
@RestController
@RequestMapping("/admin/flavors")
public class FlavorController {

    @Autowired
    private FlavorService flavorService;

    /**
     * Cria um novo sabor de pizza.
     *
     * @param flavor objeto {@link Flavor} a ser salvo
     * @return {@link ResponseEntity} com o sabor criado
     */
    @PostMapping
    public ResponseEntity<Flavor> createFlavor(@RequestBody Flavor flavor) {
        return ResponseEntity.ok(flavorService.save(flavor));
    }

    /**
     * Atualiza um sabor de pizza existente com base no ID.
     *
     * @param id identificador do sabor
     * @param flavor novo objeto {@link Flavor} com dados atualizados
     * @return {@link ResponseEntity} com o sabor atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Flavor> updateFlavor(@PathVariable Long id, @RequestBody Flavor flavor) {
        try {
            return ResponseEntity.ok(flavorService.edit(id, flavor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove um sabor de pizza com base no ID fornecido.
     *
     * @param id identificador do sabor a ser deletado
     * @return {@link ResponseEntity} com status 204 ou 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlavor(@PathVariable Long id) {
        try {
            flavorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retorna todos os sabores de pizza cadastrados.
     *
     * @return {@link ResponseEntity} contendo a lista de {@link Flavor} ou erro interno
     */
    @GetMapping
    public ResponseEntity<List<Flavor>> getAllFlavors() {
        try {
            List<Flavor> flavors = flavorService.findAll();
            return ResponseEntity.ok(flavors);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    /**
     * Retorna um sabor de pizza específico pelo ID.
     *
     * @param id identificador do sabor de pizza
     * @return {@link ResponseEntity} contendo o {@link Flavor} ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Flavor> getFlavorById(@PathVariable Long id) {
        try {
            Flavor flavor = flavorService.findById(id);
            return ResponseEntity.ok(flavor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
