package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Payment;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.PaymentEntity;

public class PaymentMapper {

    public static PaymentEntity toEntity(Payment domain) {
        if (domain == null)
            return null;
        PaymentEntity e = new PaymentEntity();
        e.setId(domain.getId());
        e.setMonto(domain.getMonto());
        e.setMetodoPago(domain.getMetodoPago());
        e.setFechaPago(domain.getFechaPago());
        e.setReservaId(domain.getReservaId());
        e.setEstadoPagoId(domain.getEstadoPagoId());
        return e;
    }

    public static Payment toDomain(PaymentEntity e) {
        if (e == null)
            return null;
        return new Payment(e.getId(), e.getReservaId(), e.getMonto(), e.getFechaPago(), e.getMetodoPago(),
                e.getEstadoPagoId());
    }
}
