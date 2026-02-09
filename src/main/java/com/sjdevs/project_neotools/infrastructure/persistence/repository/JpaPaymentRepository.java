package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.PaymentEntity;
import java.util.List;

@Repository
public interface JpaPaymentRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findByReservaId(Long reservaId);
    List<PaymentEntity> findByEstadoPagoId(Long estadoPagoId);
}
