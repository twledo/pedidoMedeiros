package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Border;
import dev.medeiros.sitePedidos.repository.BorderRepository;
import dev.medeiros.sitePedidos.service.interfaces.BorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Implementação do serviço de manipulação das bordas da pizza.
 */
@Service
public class BorderServiceImpl implements BorderService {

    private static final Logger logger = LoggerFactory.getLogger(BorderServiceImpl.class);

    @Autowired
    private BorderRepository borderRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Border save(Border border) {
        logger.info("Salvando borda: {}", border);
        return borderRepository.save(border);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Border> findAll() {
        logger.info("Buscando todas as bordas");
        return borderRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border findById(Long id) {
        logger.info("Buscando borda por ID: {}", id);
        return borderRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Borda não encontrada com ID: {}", id);
                    return new RuntimeException("Borda não encontrada com ID: " + id);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border edit(Long id, Border border) {
        logger.info("Editando borda ID: {}", id);
        Border existing = findById(id);
        existing.setName(border.getName());
        existing.setPrice(border.getPrice());
        return borderRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        logger.info("Deletando borda ID: {}", id);
        borderRepository.deleteById(id);
    }
}
