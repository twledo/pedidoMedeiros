package dev.medeiros.sitePedidos.controller.admin;

import dev.medeiros.sitePedidos.model.Drink;
import dev.medeiros.sitePedidos.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável pelo gerenciamento de bebidas disponíveis para pedidos.
 * Fornece endpoints para operações de criação, leitura, atualização e exclusão (CRUD).
 */
@RestController
@RequestMapping("/admin/drinks")
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    /**
     * Cria uma nova bebida.
     *
     * @param drink objeto {@link Drink} a ser persistido
     * @return bebida salva no repositório
     */
    @PostMapping
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    /**
     * Atualiza os dados de uma bebida existente.
     *
     * @param id identificador da bebida a ser atualizada
     * @param drinkDetails objeto {@link Drink} com os novos dados
     * @return {@link ResponseEntity} com a bebida atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable Long id, @RequestBody Drink drinkDetails) {
        return drinkRepository.findById(id)
                .map(drink -> {
                    drink.setName(drinkDetails.getName());
                    drink.setPrice(drinkDetails.getPrice());
                    return ResponseEntity.ok(drinkRepository.save(drink));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma bebida do sistema com base no ID.
     *
     * @param id identificador da bebida a ser excluída
     * @return {@link ResponseEntity} com status 204 se removida ou 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable Long id) {
        return drinkRepository.findById(id)
                .map(drink -> {
                    drinkRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Obtém uma lista de todas as bebidas disponíveis.
     *
     * @return lista de bebidas
     */
    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks() {
        try {
            List<Drink> drinks = drinkRepository.findAll();
            return ResponseEntity.ok(drinks);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    /**
     * Retorna uma bebida específica pelo ID.
     *
     * @param id identificador da bebida
     * @return {@link ResponseEntity} contendo a {@link Drink} ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable Long id) {
        try {
            Drink drink = drinkRepository.findById(id)
                    .orElseThrow(IllegalArgumentException::new);
            return ResponseEntity.ok(drink);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
