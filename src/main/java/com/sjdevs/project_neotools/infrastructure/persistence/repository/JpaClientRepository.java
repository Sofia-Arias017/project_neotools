package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByDocumento(String documento);
    Optional<ClientEntity> findByUsuarioId(Long usuarioId);
}
