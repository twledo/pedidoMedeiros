package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.SizePizza;
import dev.medeiros.sitePedidos.repository.SizePizzaRepository;
import dev.medeiros.sitePedidos.service.interfaces.SizePizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação do serviço para os tamanhos disponíveis de pizza.
 */
@Service
public class SizePizzaServiceImpl implements SizePizzaService {

    @Autowired
    private SizePizzaRepository sizePizzaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public SizePizza save(SizePizza sizePizza) {
        return sizePizzaRepository.save(sizePizza);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SizePizza> findAll() {
        return sizePizzaRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SizePizza findById(Long id) {
        return sizePizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tamanho não encontrado com ID: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SizePizza edit(Long id, SizePizza sizePizza) {
        SizePizza existing = findById(id);
        existing.setName(sizePizza.getName());
        existing.setPrice(sizePizza.getPrice());
        existing.setDescription(sizePizza.getDescription());
        return sizePizzaRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        sizePizzaRepository.deleteById(id);
    }
}
