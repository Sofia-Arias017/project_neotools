package com.sjdevs.project_neotools.infrastructure.controller;

import com.sjdevs.project_neotools.application.service.ProviderService;
import com.sjdevs.project_neotools.application.dto.ProviderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public ResponseEntity<List<ProviderDTO>> getAllProviders() {
        return ResponseEntity.ok(providerService.getAllProviders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> getProviderById(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.getProviderById(id));
    }

    @GetMapping("/empresa/{empresa}")
    public ResponseEntity<ProviderDTO> getProviderByEmpresa(@PathVariable String empresa) {
        return ResponseEntity.ok(providerService.getProviderByEmpresa(empresa));
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderDTO providerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(providerService.saveOrUpdateProvider(providerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> updateProvider(@PathVariable Long id, @RequestBody ProviderDTO providerDTO) {
        providerDTO.setId(id);
        return ResponseEntity.ok(providerService.saveOrUpdateProvider(providerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }
}
