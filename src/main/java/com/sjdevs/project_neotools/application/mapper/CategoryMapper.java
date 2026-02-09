package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Category;
import com.sjdevs.project_neotools.application.dto.CategoryDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toEntity(Category domain) {
        if (domain == null)
            return null;
        CategoryEntity e = new CategoryEntity();
        e.setId(domain.getId());
        e.setNombre(domain.getNombre());
        e.setDescripcion(domain.getDescripcion());
        return e;
    }

    public static Category toDomain(CategoryEntity e) {
        if (e == null)
            return null;
        return new Category(e.getId(), e.getNombre(), e.getDescripcion());
    }

    public static CategoryDTO toDTO(Category domain) {
        if (domain == null)
            return null;
        CategoryDTO dto = new CategoryDTO();
        dto.setId(domain.getId());
        dto.setNombre(domain.getNombre());
        dto.setDescripcion(domain.getDescripcion());
        return dto;
    }

    public static Category toDomainFromDTO(CategoryDTO dto) {
        if (dto == null)
            return null;
        return new Category(dto.getId(), dto.getNombre(), dto.getDescripcion());
    }
}
