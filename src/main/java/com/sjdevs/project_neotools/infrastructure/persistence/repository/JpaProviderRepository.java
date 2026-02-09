package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaProviderRepository extends JpaRepository<ProviderEntity, Long> {
    Optional<ProviderEntity> findByEmpresa(String empresa);
}
