package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.domain.model.Provider;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import com.sjdevs.project_neotools.application.dto.ProviderDTO;
import com.sjdevs.project_neotools.application.mapper.ProviderMapper;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaProviderRepository;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {

    @Autowired
    private JpaProviderRepository jpaProviderRepository;

    public List<ProviderDTO> getAllProviders() {
        return jpaProviderRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProviderDTO getProviderById(Long id) {
        ProviderEntity providerEntity = jpaProviderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
        return toDTO(providerEntity);
    }

    public ProviderDTO getProviderByEmpresa(String empresa) {
        ProviderEntity providerEntity = jpaProviderRepository.findByEmpresa(empresa)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con empresa: " + empresa));
        return toDTO(providerEntity);
    }

    public ProviderDTO saveOrUpdateProvider(ProviderDTO providerDTO) {
        Provider provider = ProviderMapper.toDomainFromDTO(providerDTO);
        ProviderEntity providerEntity = ProviderMapper.toEntity(provider);
        ProviderEntity savedEntity = jpaProviderRepository.save(providerEntity);
        return toDTO(savedEntity);
    }

    public void deleteProvider(Long id) {
        jpaProviderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
        jpaProviderRepository.deleteById(id);
    }

    private ProviderDTO toDTO(ProviderEntity providerEntity) {
        Provider provider = ProviderMapper.toDomain(providerEntity);
        return ProviderMapper.toDTO(provider);
    }
}
