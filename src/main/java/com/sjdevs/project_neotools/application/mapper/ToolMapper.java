package com.sjdevs.project_neotools.application.mapper;

import com.sjdevs.project_neotools.domain.model.Tool;
import com.sjdevs.project_neotools.application.dto.ToolDTO;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ToolEntity;

public class ToolMapper {

    public static ToolEntity toEntity(Tool domain) {
        if (domain == null)
            return null;
        ToolEntity e = new ToolEntity();
        e.setId(domain.getId());
        e.setCodigoInventario(domain.getCodigoInventario());
        e.setNombre(domain.getNombre());
        e.setMarca(domain.getMarca());
        e.setModelo(domain.getModelo());
        e.setDescripcion(domain.getDescripcion());
        e.setFechaAdquisicion(domain.getFechaAdquisicion());
        e.setValorReposicion(domain.getValorReposicion());
        e.setCondicionActual(domain.getCondicionActual());
        e.setProveedorId(domain.getProveedorId());
        e.setCategoriaId(domain.getCategoriaId());
        e.setEstadoHerramientaId(domain.getEstadoHerramientaId());
        return e;
    }

    public static Tool toDomain(ToolEntity e) {
        if (e == null)
            return null;
        return new Tool(e.getId(), e.getCodigoInventario(), e.getNombre(), e.getMarca(), e.getModelo(),
                e.getDescripcion(), e.getFechaAdquisicion(), e.getValorReposicion(),
                e.getCondicionActual(), e.getProveedorId(), e.getCategoriaId(), e.getEstadoHerramientaId());
    }

    public static ToolDTO toDTO(Tool domain) {
        if (domain == null)
            return null;
        ToolDTO dto = new ToolDTO();
        dto.setId(domain.getId());
        dto.setCodigoInventario(domain.getCodigoInventario());
        dto.setNombre(domain.getNombre());
        dto.setMarca(domain.getMarca());
        dto.setModelo(domain.getModelo());
        dto.setDescripcion(domain.getDescripcion());
        dto.setFechaAdquisicion(domain.getFechaAdquisicion());
        dto.setValorReposicion(domain.getValorReposicion());
        dto.setCondicionActual(domain.getCondicionActual());
        dto.setProveedorId(domain.getProveedorId());
        dto.setCategoriaId(domain.getCategoriaId());
        dto.setEstadoHerramientaId(domain.getEstadoHerramientaId());
        return dto;
    }

    public static Tool toDomainFromDTO(ToolDTO dto) {
        if (dto == null)
            return null;
        return new Tool(dto.getId(), dto.getCodigoInventario(), dto.getNombre(), dto.getMarca(), dto.getModelo(),
                dto.getDescripcion(), dto.getFechaAdquisicion(), dto.getValorReposicion(),
                dto.getCondicionActual(), dto.getProveedorId(), dto.getCategoriaId(), dto.getEstadoHerramientaId());
    }
}
