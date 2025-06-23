package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Drink;
import dev.medeiros.sitePedidos.repository.DrinkRepository;
import dev.medeiros.sitePedidos.service.interfaces.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Implementação do serviço de bebidas disponíveis no pedido.
 */
@Service
public class DrinkServiceImpl implements DrinkService {

    private static final Logger logger = LoggerFactory.getLogger(DrinkServiceImpl.class);

    @Autowired
    private DrinkRepository drinkRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Drink save(Drink drink) {
        logger.info("Salvando bebida: {}", drink);
        return drinkRepository.save(drink);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Drink> findAll() {
        logger.info("Buscando todas as bebidas");
        return drinkRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Drink findById(Long id) {
        logger.info("Buscando bebida por ID: {}", id);
        return drinkRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Bebida não encontrada com ID: {}", id);
                    return new RuntimeException("Bebida não encontrada com ID: " + id);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Drink edit(Long id, Drink drink) {
        logger.info("Editando bebida ID: {}", id);
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
        logger.info("Deletando bebida ID: {}", id);
        drinkRepository.deleteById(id);
    }
}
