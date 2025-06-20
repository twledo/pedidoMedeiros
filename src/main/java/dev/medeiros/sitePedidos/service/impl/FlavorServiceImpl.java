package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Flavor;
import dev.medeiros.sitePedidos.repository.FlavorRepository;
import dev.medeiros.sitePedidos.service.interfaces.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação do serviço para gerenciamento de sabores de pizza.
 */
@Service
public class FlavorServiceImpl implements FlavorService {

    @Autowired
    private FlavorRepository flavorRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Flavor save(Flavor flavor) {
        return flavorRepository.save(flavor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Flavor> findAll() {
        return flavorRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Flavor findById(Long id) {
        return flavorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sabor não encontrado com ID: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Flavor edit(Long id, Flavor flavor) {
        Flavor existing = findById(id);
        existing.setName(flavor.getName());
        return flavorRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        flavorRepository.deleteById(id);
    }
}
