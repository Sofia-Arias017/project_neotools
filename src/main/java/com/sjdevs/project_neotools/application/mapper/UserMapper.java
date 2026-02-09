package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.User;
import com.sjdevs.project_neotools.application.dto.UserDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;
        UserEntity e = new UserEntity();
        e.setId(domain.getId());
        e.setUsername(domain.getUsername());
        e.setEmail(domain.getEmail());
        e.setPassword(domain.getPassword());
        e.setEstado(domain.getEstado());
        e.setCreatedAt(domain.getCreatedAt());
        e.setLastLogin(domain.getLastLogin());
        return e;
    }

    public static User toDomain(UserEntity e) {
        if (e == null) return null;
        return new User(e.getId(), e.getUsername(), e.getEmail(), e.getPassword(), e.getEstado(),
                e.getCreatedAt(), e.getLastLogin());
    }

    public static UserDTO toDTO(User domain) {
        if (domain == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(domain.getId());
        dto.setUsername(domain.getUsername());
        dto.setEmail(domain.getEmail());
        dto.setPassword(domain.getPassword());
        dto.setEstado(domain.getEstado());
        dto.setCreatedAt(domain.getCreatedAt());
        dto.setLastLogin(domain.getLastLogin());
        return dto;
    }

    public static User toDomainFromDTO(UserDTO dto) {
        if (dto == null) return null;
        return new User(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getEstado(),
                dto.getCreatedAt(), dto.getLastLogin());
    }
}
