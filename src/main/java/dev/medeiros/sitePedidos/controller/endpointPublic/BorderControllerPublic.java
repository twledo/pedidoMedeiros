package dev.medeiros.sitePedidos.controller.endpointPublic;

import dev.medeiros.sitePedidos.model.Border;
import dev.medeiros.sitePedidos.service.interfaces.BorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST público para consulta das bordas disponíveis das pizzas.
 * Acesso liberado para clientes (sem autenticação).
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/public/borders")
public class BorderControllerPublic {

    @Autowired
    private BorderService borderService;

    /**
     * Lista todas as bordas disponíveis para o cliente.
     *
     * @return lista de {@link Border}
     */
    @GetMapping
    public ResponseEntity<List<Border>> getAll() {
        return ResponseEntity.ok(borderService.findAll());
    }
}
