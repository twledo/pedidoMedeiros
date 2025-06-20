package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Border;
import dev.medeiros.sitePedidos.repository.BorderRepository;
import dev.medeiros.sitePedidos.service.interfaces.BorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação do serviço de manipulação das bordas da pizza.
 */
@Service
public class BorderServiceImpl implements BorderService {

    @Autowired
    private BorderRepository borderRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Border save(Border border) {
        return borderRepository.save(border);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Border> findAll() {
        return borderRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border findById(Long id) {
        return borderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borda não encontrada com ID: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border edit(Long id, Border border) {
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
        borderRepository.deleteById(id);
    }
}
