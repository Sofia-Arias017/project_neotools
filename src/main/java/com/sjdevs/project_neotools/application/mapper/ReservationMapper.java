package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Reservation;
import com.sjdevs.project_neotools.application.dto.ReservationDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ReservationEntity;

public class ReservationMapper {

    public static ReservationEntity toEntity(Reservation domain) {
        if (domain == null)
            return null;
        ReservationEntity e = new ReservationEntity();
        e.setId(domain.getId());
        e.setClienteId(domain.getClienteId());
        e.setHerramientaId(domain.getHerramientaId());
        e.setFechaInicio(domain.getFechaInicio());
        e.setFechaFinEstimada(domain.getFechaFinEstimada());
        e.setFechaCreacion(domain.getFechaCreacion());
        e.setEstadoReservaId(domain.getEstadoReservaId());
        e.setObservaciones(domain.getObservaciones());
        return e;
    }

    public static Reservation toDomain(ReservationEntity e) {
        if (e == null)
            return null;
        return new Reservation(e.getId(), e.getClienteId(), e.getFechaInicio(),
                e.getFechaFinEstimada(), e.getFechaCreacion(), e.getEstadoReservaId(),
                e.getObservaciones());
    }

    public static ReservationDTO toDTO(Reservation domain) {
        if (domain == null)
            return null;
        ReservationDTO dto = new ReservationDTO();
        dto.setId(domain.getId());
        dto.setClienteId(domain.getClienteId());
        dto.setHerramientaId(domain.getHerramientaId());
        dto.setFechaInicio(domain.getFechaInicio());
        dto.setFechaFinEstimada(domain.getFechaFinEstimada());
        dto.setFechaCreacion(domain.getFechaCreacion());
        dto.setEstadoReservaId(domain.getEstadoReservaId());
        dto.setObservaciones(domain.getObservaciones());
        return dto;
    }

    public static Reservation toDomainFromDTO(ReservationDTO dto) {
        if (dto == null)
            return null;
        return new Reservation(dto.getId(), dto.getClienteId(), dto.getFechaInicio(),
                dto.getFechaFinEstimada(), dto.getFechaCreacion(), dto.getEstadoReservaId(),
                dto.getObservaciones());
    }
}
