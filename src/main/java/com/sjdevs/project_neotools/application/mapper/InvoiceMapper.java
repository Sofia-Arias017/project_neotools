package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Invoice;
import com.sjdevs.project_neotools.application.dto.InvoiceDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.InvoiceEntity;

public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice domain) {
        if (domain == null)
            return null;
        InvoiceEntity e = new InvoiceEntity();
        e.setId(domain.getId());
        e.setNumeroFactura(domain.getNumeroFactura());
        e.setFechaEmision(domain.getFechaEmision());
        e.setTotal(domain.getTotal());
        e.setPagoId(domain.getPagoId());
        return e;
    }

    public static Invoice toDomain(InvoiceEntity e) {
        if (e == null)
            return null;
        return new Invoice(e.getId(), e.getNumeroFactura(), e.getFechaEmision(), e.getTotal(), e.getPagoId());
    }

    public static InvoiceDTO toDTO(Invoice domain) {
        if (domain == null)
            return null;
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(domain.getId());
        dto.setNumeroFactura(domain.getNumeroFactura());
        dto.setFechaEmision(domain.getFechaEmision());
        dto.setTotal(domain.getTotal());
        dto.setPagoId(domain.getPagoId());
        return dto;
    }

    public static Invoice toDomainFromDTO(InvoiceDTO dto) {
        if (dto == null)
            return null;
        return new Invoice(dto.getId(), dto.getNumeroFactura(), dto.getFechaEmision(), dto.getTotal(), dto.getPagoId());
    }
}
