package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.domain.model.Client;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import com.sjdevs.project_neotools.application.dto.ClientDTO;
import com.sjdevs.project_neotools.application.mapper.ClientMapper;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaClientRepository;
import com.sjdevs.project_neotools.infrastructure.persistence.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private JpaClientRepository jpaClientRepository;

    public List<ClientDTO> getAllClients() {
        return jpaClientRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        ClientEntity clientEntity = jpaClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
        return toDTO(clientEntity);
    }

    public ClientDTO getClientByDocumento(String documento) {
        ClientEntity clientEntity = jpaClientRepository.findByDocumento(documento)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con documento: " + documento));
        return toDTO(clientEntity);
    }

    public ClientDTO saveOrUpdateClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toDomainFromDTO(clientDTO);
        ClientEntity clientEntity = ClientMapper.toEntity(client);
        ClientEntity savedEntity = jpaClientRepository.save(clientEntity);
        return toDTO(savedEntity);
    }

    public void deleteClient(Long id) {
        jpaClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
        jpaClientRepository.deleteById(id);
    }

    private ClientDTO toDTO(ClientEntity clientEntity) {
        Client client = ClientMapper.toDomain(clientEntity);
        return ClientMapper.toDTO(client);
    }
}
