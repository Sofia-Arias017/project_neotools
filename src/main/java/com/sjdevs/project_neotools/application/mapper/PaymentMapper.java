package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Payment;
import com.sjdevs.project_neotools.application.dto.PaymentDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.PaymentEntity;

public class PaymentMapper {

    public static PaymentEntity toEntity(Payment domain) {
        if (domain == null)
            return null;
        PaymentEntity e = new PaymentEntity();
        e.setId(domain.getId());
        e.setReservaId(domain.getReservaId());
        e.setConcepto(domain.getConcepto());
        e.setMonto(domain.getMonto());
        e.setFechaPago(domain.getFechaPago());
        e.setEstadoPagoId(domain.getEstadoPagoId());
        return e;
    }

    public static Payment toDomain(PaymentEntity e) {
        if (e == null)
            return null;
        return new Payment(e.getId(), e.getReservaId(), e.getConcepto(), e.getMonto(), e.getFechaPago(),
                e.getEstadoPagoId());
    }

    public static PaymentDTO toDTO(Payment domain) {
        if (domain == null)
            return null;
        PaymentDTO dto = new PaymentDTO();
        dto.setId(domain.getId());
        dto.setReservaId(domain.getReservaId());
        dto.setConcepto(domain.getConcepto());
        dto.setMonto(domain.getMonto());
        dto.setFechaPago(domain.getFechaPago());
        dto.setEstadoPagoId(domain.getEstadoPagoId());
        return dto;
    }

    public static Payment toDomainFromDTO(PaymentDTO dto) {
        if (dto == null)
            return null;
        return new Payment(dto.getId(), dto.getReservaId(), dto.getConcepto(), dto.getMonto(), dto.getFechaPago(),
                dto.getEstadoPagoId());
    }
}
