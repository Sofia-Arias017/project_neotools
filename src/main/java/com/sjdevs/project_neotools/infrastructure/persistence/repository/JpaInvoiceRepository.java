package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import com.sjdevs.project_neotools.infrastructure.persistence.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    Optional<InvoiceEntity> findByNumeroFactura(String numeroFactura);
    Optional<InvoiceEntity> findByPagoId(Long pagoId);
}
