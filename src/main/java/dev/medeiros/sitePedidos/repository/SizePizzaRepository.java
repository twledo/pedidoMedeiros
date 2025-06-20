package dev.medeiros.sitePedidos.repository;

import dev.medeiros.sitePedidos.model.SizePizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizePizzaRepository extends JpaRepository<SizePizza, Long> {
}
