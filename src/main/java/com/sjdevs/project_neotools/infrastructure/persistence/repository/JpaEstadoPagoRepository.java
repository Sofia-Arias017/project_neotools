package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.EstadoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaEstadoPagoRepository extends JpaRepository<EstadoPagoEntity, Long> {
    Optional<EstadoPagoEntity> findByNombre(String nombre);
}
