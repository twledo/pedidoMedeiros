package dev.medeiros.sitePedidos.controller.endpointPublic;

import dev.medeiros.sitePedidos.enums.TypeFlavors;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    /**
     * Endpoint público para buscar sabores de pizza filtrados pelo tipo informado (ex: "doce", "salgada").
     *
     * O valor informado como parâmetro será convertido para um valor do enum {@link TypeFlavors},
     * ignorando letras maiúsculas/minúsculas e espaços. Caso o tipo seja inválido ou inexistente,
     * retorna HTTP 400 (Bad Request).
     *
     * @param type tipo de sabor desejado ("doce" ou "salgada")
     * @return {@link ResponseEntity} contendo a lista de sabores filtrados ou status 400 em caso de erro de conversão
     */
    @GetMapping("/filter")
    public ResponseEntity<List<Flavor>> getByType(@RequestParam String type) {
        try {
            TypeFlavors typeEnum = TypeFlavors.fromStringIgnoreCase(type);
            List<Flavor> filtered = flavorService.findByType(typeEnum);
            return ResponseEntity.ok(filtered);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
