package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ToolEntity;
import java.util.List;

@Repository
public interface JpaToolRepository extends JpaRepository<ToolEntity, Long> {
    List<ToolEntity> findByProveedorId(Long proveedorId);
    List<ToolEntity> findByCategoriaId(Long categoriaId);
}
