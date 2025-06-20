package dev.medeiros.sitePedidos.repository;

import dev.medeiros.sitePedidos.enums.TypeFlavors;
import dev.medeiros.sitePedidos.model.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlavorRepository extends JpaRepository<Flavor, Long> {

    /**
     * Retorna todos os sabores que possuem o campo {@code tipo} igual ao valor informado,
     * ignorando se está em maiúsculas ou minúsculas.
     *
     * @param tipo o tipo de sabor desejado (ex: "doce" ou "salgado")
     * @return lista de {@link Flavor} com o tipo correspondente
     */
    List<Flavor> findByType(TypeFlavors type);
}
