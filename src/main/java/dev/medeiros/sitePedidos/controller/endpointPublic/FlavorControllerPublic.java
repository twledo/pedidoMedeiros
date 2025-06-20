package dev.medeiros.sitePedidos.controller.endpointPublic;

import dev.medeiros.sitePedidos.model.Flavor;
import dev.medeiros.sitePedidos.service.interfaces.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST público para consulta dos sabores de pizza disponíveis.
 * Acesso liberado para clientes (sem autenticação).
 */
@RestController
@RequestMapping("/public/flavors")
public class FlavorControllerPublic {

    @Autowired
    private FlavorService flavorService;

    /**
     * Lista todos os sabores de pizza disponíveis para o cliente.
     *
     * @return {@link ResponseEntity} contendo a lista de {@link Flavor}
     */
    @GetMapping
    public ResponseEntity<List<Flavor>> getAll() {
        return ResponseEntity.ok(flavorService.findAll());
    }

    /**
     * Retorna um sabor específico de pizza pelo ID para visualização pública.
     *
     * @param id identificador do sabor
     * @return {@link ResponseEntity} com o sabor encontrado ou 404 se não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Flavor> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(flavorService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
