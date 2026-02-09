package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.EstadoHerramientaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaEstadoHerramientaRepository extends JpaRepository<EstadoHerramientaEntity, Long> {
    Optional<EstadoHerramientaEntity> findByNombre(String nombre);
}
