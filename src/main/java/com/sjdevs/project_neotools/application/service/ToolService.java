package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.application.mapper.ToolMapper;
import com.sjdevs.project_neotools.application.dto.ToolDTO;
import com.sjdevs.project_neotools.domain.model.Tool;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaToolRepository;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolService {

    @Autowired
    private JpaToolRepository toolRepository;

    public List<ToolDTO> getAllTools() {
        return toolRepository.findAll().stream()
                .map(ToolMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ToolDTO getToolById(Long id) {
        return toolRepository.findById(id)
                .map(ToolMapper::toDomain)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Tool not found with id: " + id));
    }

    public ToolDTO saveOrUpdateTool(ToolDTO toolDTO) {
        Tool tool = fromDTO(toolDTO);
        return toDTO(ToolMapper.toDomain(toolRepository.save(ToolMapper.toEntity(tool))));
    }

    public void deleteTool(Long id) {
        toolRepository.deleteById(id);
    }

    public List<ToolDTO> getToolsByProveedorId(Long proveedorId) {
        return toolRepository.findByProveedorId(proveedorId).stream()
                .map(ToolMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ToolDTO> getToolsByCategoria(Long categoriaId) {
        return toolRepository.findByCategoriaId(categoriaId).stream()
                .map(ToolMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ToolDTO toDTO(Tool tool) {
        if (tool == null) return null;
        ToolDTO dto = new ToolDTO();
        dto.setId(tool.getId());
        dto.setCodigoInventario(tool.getCodigoInventario());
        dto.setNombre(tool.getNombre());
        dto.setMarca(tool.getMarca());
        dto.setModelo(tool.getModelo());
        dto.setDescripcion(tool.getDescripcion());
        dto.setFechaAdquisicion(tool.getFechaAdquisicion());
        dto.setValorReposicion(tool.getValorReposicion());
        dto.setCondicionActual(tool.getCondicionActual());
        dto.setProveedorId(tool.getProveedorId());
        dto.setCategoriaId(tool.getCategoriaId());
        dto.setEstadoHerramientaId(tool.getEstadoHerramientaId());
        return dto;
    }

    private Tool fromDTO(ToolDTO dto) {
        if (dto == null) return null;
        return new Tool(dto.getId(), dto.getCodigoInventario(), dto.getNombre(), dto.getMarca(), 
                dto.getModelo(), dto.getDescripcion(), dto.getFechaAdquisicion(), 
                dto.getValorReposicion(), dto.getCondicionActual(), dto.getProveedorId(), 
                dto.getCategoriaId(), dto.getEstadoHerramientaId());
    }
}
