package dev.medeiros.sitePedidos.repository;

import dev.medeiros.sitePedidos.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
