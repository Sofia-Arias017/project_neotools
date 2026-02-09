package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Role;
import com.sjdevs.project_neotools.application.dto.RoleDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.RoleEntity;

public class RoleMapper {

    public static RoleEntity toEntity(Role domain) {
        if (domain == null)
            return null;
        RoleEntity e = new RoleEntity();
        e.setId(domain.getId());
        e.setNombre(domain.getNombre());
        return e;
    }

    public static Role toDomain(RoleEntity e) {
        if (e == null)
            return null;
        return new Role(e.getId(), e.getNombre());
    }

    public static RoleDTO toDTO(Role domain) {
        if (domain == null)
            return null;
        RoleDTO dto = new RoleDTO();
        dto.setId(domain.getId());
        dto.setNombre(domain.getNombre());
        return dto;
    }

    public static Role toDomainFromDTO(RoleDTO dto) {
        if (dto == null)
            return null;
        return new Role(dto.getId(), dto.getNombre());
    }
}
