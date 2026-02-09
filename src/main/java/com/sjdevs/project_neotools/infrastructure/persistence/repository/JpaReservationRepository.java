package com.sjdevs.project_neotools.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ReservationEntity;
import java.util.List;

@Repository
public interface JpaReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByClienteId(Long clienteId);
    List<ReservationEntity> findByEstadoReservaId(Long estadoReservaId);
}
