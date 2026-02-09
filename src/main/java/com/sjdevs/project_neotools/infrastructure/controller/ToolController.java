package com.sjdevs.project_neotools.infrastructure.controller;

import com.sjdevs.project_neotools.application.service.ToolService;
import com.sjdevs.project_neotools.application.dto.ToolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping
    public ResponseEntity<List<ToolDTO>> getAllTools() {
        return ResponseEntity.ok(toolService.getAllTools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolDTO> getToolById(@PathVariable Long id) {
        return ResponseEntity.ok(toolService.getToolById(id));
    }

    @PostMapping
    public ResponseEntity<ToolDTO> createTool(@RequestBody ToolDTO toolDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toolService.saveOrUpdateTool(toolDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToolDTO> updateTool(@PathVariable Long id, @RequestBody ToolDTO toolDTO) {
        toolDTO.setId(id);
        return ResponseEntity.ok(toolService.saveOrUpdateTool(toolDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<ToolDTO>> getToolsByProveedor(@PathVariable Long proveedorId) {
        return ResponseEntity.ok(toolService.getToolsByProveedorId(proveedorId));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ToolDTO>> getToolsByCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(toolService.getToolsByCategoria(categoriaId));
    }
}
