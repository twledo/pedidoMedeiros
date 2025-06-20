package dev.medeiros.sitePedidos.repository;

import dev.medeiros.sitePedidos.model.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorRepository extends JpaRepository<Flavor, Long> {
}
