package dev.medeiros.sitePedidos.controller.endpointPublic;

import dev.medeiros.sitePedidos.model.Drink;
import dev.medeiros.sitePedidos.service.interfaces.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST público para consulta das bebidas disponíveis.
 * Acesso liberado para clientes (sem autenticação).
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/public/drinks")
public class DrinkControllerPublic {

    @Autowired
    private DrinkService drinkService;

    /**
     * Lista todas as bebidas disponíveis para o cliente.
     *
     * @return {@link ResponseEntity} contendo a lista de {@link Drink}
     */
    @GetMapping
    public ResponseEntity<List<Drink>> getAll() {
        return ResponseEntity.ok(drinkService.findAll());
    }
}
