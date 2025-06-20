package dev.medeiros.sitePedidos.repository;

import dev.medeiros.sitePedidos.model.Border;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorderRepository extends JpaRepository<Border, Long> {
}
