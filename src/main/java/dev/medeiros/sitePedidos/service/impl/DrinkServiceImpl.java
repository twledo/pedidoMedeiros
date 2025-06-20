package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Drink;
import dev.medeiros.sitePedidos.repository.DrinkRepository;
import dev.medeiros.sitePedidos.service.interfaces.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação do serviço de bebidas disponíveis no pedido.
 */
@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Drink save(Drink drink) {
        return drinkRepository.save(drink);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Drink findById(Long id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bebida não encontrada com ID: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Drink edit(Long id, Drink drink) {
        Drink existing = findById(id);
        existing.setName(drink.getName());
        existing.setPrice(drink.getPrice());
        return drinkRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        drinkRepository.deleteById(id);
    }
}
