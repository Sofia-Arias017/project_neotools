package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Reservation;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ReservationEntity;

public class ReservationMapper {

    public static ReservationEntity toEntity(Reservation domain) {
        if (domain == null)
            return null;
        ReservationEntity e = new ReservationEntity();
        e.setId(domain.getId());
        e.setFechaInicio(domain.getFechaInicio());
        e.setFechaFin(domain.getFechaFin());
        e.setClienteId(domain.getClienteId());
        e.setHerramientaId(domain.getHerramientaId());
        e.setEstadoReservaId(domain.getEstadoReservaId());
        return e;
    }

    public static Reservation toDomain(ReservationEntity e) {
        if (e == null)
            return null;
        return new Reservation(e.getId(), e.getFechaInicio(), e.getFechaFin(), e.getClienteId(), e.getHerramientaId(),
                e.getEstadoReservaId());
    }
}
