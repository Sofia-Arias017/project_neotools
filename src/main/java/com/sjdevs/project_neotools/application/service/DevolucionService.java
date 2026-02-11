package com.sjdevs.project_neotools.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjdevs.project_neotools.application.dto.DevolucionDTO;
import com.sjdevs.project_neotools.application.dto.PaymentDTO;
import com.sjdevs.project_neotools.domain.model.Devolucion;
import com.sjdevs.project_neotools.domain.model.Payment;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaDevolucionRepository;

@Service
public class DevolucionService {

    @Autowired
    private JpaDevolucionRepository jpaDevolucionRepository;

    public DevolucionDTO guardarOActualizarDevolucion(DevolucionDTO DevolucionDTO) {
        Devolucion = fromDTO(DevolucionDTO);
        return toDTO(DevolucionMapper.toDomain(jpaDevolucionRepository.save(DevolucionMapper.toEntity(devolucion))));
    }

    private DevolucionDTO toDTO(Devolucion devolucion) {
        if (devolucion == null) return null;
        DevolucionDTO dto = new DevolucionDTO();
        dto.setId(devolucion.getId());
        dto.setDescripcionDano(devolucion.getDescripcion());
        dto.setCostoReparacion(devolucion.getCostoReparacion());
        dto.setFechaReparacion(devolucion.getFechaReparacion());
        return dto;
    }

    private Devolucion fromDTO(DevolucionDTO dto) {
        if (dto == null) return null;
        return new getId(), dto.getDescripcion(), dto.getCostoReparacion(), dto.getFechaReparacion()} ;
}
