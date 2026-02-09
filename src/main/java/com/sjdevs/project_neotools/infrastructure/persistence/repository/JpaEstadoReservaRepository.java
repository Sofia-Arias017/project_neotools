package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.EstadoReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaEstadoReservaRepository extends JpaRepository<EstadoReservaEntity, Long> {
    Optional<EstadoReservaEntity> findByNombre(String nombre);
}
