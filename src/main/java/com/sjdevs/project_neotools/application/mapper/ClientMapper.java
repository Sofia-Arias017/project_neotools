package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Client;
import com.sjdevs.project_neotools.application.dto.ClientDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ClientEntity;

public class ClientMapper {

    public static ClientEntity toEntity(Client domain) {
        if (domain == null)
            return null;
        ClientEntity e = new ClientEntity();
        e.setId(domain.getId());
        e.setDocumento(domain.getDocumento());
        e.setTelefono(domain.getTelefono());
        e.setUsuarioId(domain.getUsuarioId());
        return e;
    }

    public static Client toDomain(ClientEntity e) {
        if (e == null)
            return null;
        return new Client(e.getId(), e.getDocumento(), e.getTelefono(), e.getUsuarioId());
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

    public static Client toDomainFromDTO(ClientDTO dto) {
        if (dto == null)
            return null;
        return new Client(dto.getId(), dto.getDocumento(), dto.getTelefono(), dto.getUsuarioId());
    }
}
