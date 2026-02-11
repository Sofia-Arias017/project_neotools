package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import java.util.Optional;

import com.sjdevs.project_neotools.domain.model.Devolucion;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.EstadoHerramientaEntity;

public interface JpaDevolucionRepository extends JpaDevolucion<Devolucion, Long> {
    Optional<EstadoHerramientaEntity> findByNombre(String nombre);
}
