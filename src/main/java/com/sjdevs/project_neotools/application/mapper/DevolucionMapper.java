package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.application.dto.ClientDTO;
import com.sjdevs.project_neotools.domain.model.Client;
import com.sjdevs.project_neotools.domain.model.Devolucion;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ClientEntity;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ReporteDano;

public class DevolucionMapper {
    public static Devolucion toDomain(Devolucion e) {
        if (e == null)
            return null;
        return new Devolucion(e.getId(), e.getFechaReparacion(), e.getDescripcion(), e.getCostoReparacion());
    }

    public static ClientDTO toDTO(Client domain) {
        if (domain == null)
            return null;
        ClientDTO dto = new ClientDTO();
        dto.setId(domain.getId());
        dto.setDocumento(domain.getDocumento());
        dto.setTelefono(domain.getTelefono());
        dto.setUsuarioId(domain.getUsuarioId());
        return dto;
    }
}
