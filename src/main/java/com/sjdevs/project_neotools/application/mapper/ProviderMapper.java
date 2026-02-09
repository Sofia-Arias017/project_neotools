package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Provider;
import com.sjdevs.project_neotools.application.dto.ProviderDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ProviderEntity;

public class ProviderMapper {

    public static ProviderEntity toEntity(Provider domain) {
        if (domain == null)
            return null;
        ProviderEntity e = new ProviderEntity();
        e.setId(domain.getId());
        e.setEmpresa(domain.getEmpresa());
        e.setTelefono(domain.getTelefono());
        e.setEstado(domain.getEstado());
        e.setUsuarioId(domain.getUsuarioId());
        return e;
    }

    public static Provider toDomain(ProviderEntity e) {
        if (e == null)
            return null;
        return new Provider(e.getId(), e.getEmpresa(), e.getTelefono(), e.getEstado(), e.getUsuarioId());
    }

    public static ProviderDTO toDTO(Provider domain) {
        if (domain == null)
            return null;
        ProviderDTO dto = new ProviderDTO();
        dto.setId(domain.getId());
        dto.setEmpresa(domain.getEmpresa());
        dto.setTelefono(domain.getTelefono());
        dto.setEstado(domain.getEstado());
        dto.setUsuarioId(domain.getUsuarioId());
        return dto;
    }

    public static Provider toDomainFromDTO(ProviderDTO dto) {
        if (dto == null)
            return null;
        return new Provider(dto.getId(), dto.getEmpresa(), dto.getTelefono(), dto.getEstado(), dto.getUsuarioId());
    }
}
