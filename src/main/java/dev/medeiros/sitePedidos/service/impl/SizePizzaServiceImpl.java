package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.SizePizza;
import dev.medeiros.sitePedidos.repository.SizePizzaRepository;
import dev.medeiros.sitePedidos.service.interfaces.SizePizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Implementação do serviço para os tamanhos disponíveis de pizza.
 */
@Service
public class SizePizzaServiceImpl implements SizePizzaService {

    private static final Logger logger = LoggerFactory.getLogger(SizePizzaServiceImpl.class);

    @Autowired
    private SizePizzaRepository sizePizzaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public SizePizza save(SizePizza sizePizza) {
        logger.info("Salvando tamanho de pizza: {}", sizePizza);
        return sizePizzaRepository.save(sizePizza);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SizePizza> findAll() {
        logger.info("Buscando todos os tamanhos de pizza");
        return sizePizzaRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SizePizza findById(Long id) {
        logger.info("Buscando tamanho de pizza por ID: {}", id);
        return sizePizzaRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Tamanho não encontrado com ID: {}", id);
                    return new RuntimeException("Tamanho não encontrado com ID: " + id);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SizePizza edit(Long id, SizePizza sizePizza) {
        logger.info("Editando tamanho de pizza ID: {}", id);
        SizePizza existing = findById(id);
        existing.setName(sizePizza.getName());
        existing.setPrice(sizePizza.getPrice());
        existing.setDescription(sizePizza.getDescription());
        existing.setPieces(sizePizza.getPieces());
        existing.setFlavorsQuantity(sizePizza.getFlavorsQuantity());
        return sizePizzaRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        logger.info("Deletando tamanho de pizza ID: {}", id);
        sizePizzaRepository.deleteById(id);
    }
}
