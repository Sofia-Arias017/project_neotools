package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Tool;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ToolEntity;

public class ToolMapper {

    public static ToolEntity toEntity(Tool domain) {
        if (domain == null)
            return null;
        ToolEntity e = new ToolEntity();
        e.setId(domain.getId());
        e.setNombre(domain.getNombre());
        e.setDescripcion(domain.getDescripcion());
        e.setPrecioDia(domain.getPrecioDia());
        e.setCreatedAt(domain.getCreatedAt());
        e.setProveedorId(domain.getProveedorId());
        e.setEstadoHerramientaId(domain.getEstadoHerramientaId());
        e.setCategoriaId(domain.getCategoriaId());
        return e;
    }

    public static Tool toDomain(ToolEntity e) {
        if (e == null)
            return null;
        return new Tool(e.getId(), e.getNombre(), e.getDescripcion(), e.getPrecioDia(), e.getCreatedAt(),
                e.getProveedorId(), e.getEstadoHerramientaId(), e.getCategoriaId());
    }
}
