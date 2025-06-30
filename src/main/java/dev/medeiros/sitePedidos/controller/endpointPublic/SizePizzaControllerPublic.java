package dev.medeiros.sitePedidos.controller.endpointPublic;

import dev.medeiros.sitePedidos.model.Flavor;
import dev.medeiros.sitePedidos.model.SizePizza;
import dev.medeiros.sitePedidos.service.interfaces.SizePizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST público para consulta dos tamanhos de pizza disponíveis.
 * Acesso liberado para clientes (sem autenticação).
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/public/sizes")
public class SizePizzaControllerPublic {

    @Autowired
    private SizePizzaService sizePizzaService;

    /**
     * Lista todos os tamanhos de pizza disponíveis para o cliente.
     *
     * @return {@link ResponseEntity} contendo a lista de {@link SizePizza}
     */
    @GetMapping
    public ResponseEntity<List<SizePizza>> getAll() {
        return ResponseEntity.ok(sizePizzaService.findAll());
    }
}
