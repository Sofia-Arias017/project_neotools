package com.sjdevs.project_neotools.application.service;

import com.sjdevs.project_neotools.application.mapper.ReservationMapper;
import com.sjdevs.project_neotools.application.dto.ReservationDTO;
import com.sjdevs.project_neotools.domain.model.Reservation;
import com.sjdevs.project_neotools.infrastructure.persistence.repository.JpaReservationRepository;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private JpaReservationRepository reservationRepository;

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(ReservationMapper::toDomain)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
    }

    public ReservationDTO saveOrUpdateReservation(ReservationDTO reservationDTO) {
        Reservation reservation = fromDTO(reservationDTO);
        return toDTO(ReservationMapper.toDomain(reservationRepository.save(ReservationMapper.toEntity(reservation))));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<ReservationDTO> getReservationsByCliente(Long clienteId) {
        return reservationRepository.findByClienteId(clienteId).stream()
                .map(ReservationMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> getReservationsByEstado(Long estadoId) {
        return reservationRepository.findByEstadoReservaId(estadoId).stream()
                .map(ReservationMapper::toDomain)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null) return null;
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setClienteId(reservation.getClienteId());
        dto.setHerramientaId(reservation.getHerramientaId());
        dto.setFechaInicio(reservation.getFechaInicio());
        dto.setFechaFinEstimada(reservation.getFechaFinEstimada());
        dto.setFechaCreacion(reservation.getFechaCreacion());
        dto.setEstadoReservaId(reservation.getEstadoReservaId());
        dto.setObservaciones(reservation.getObservaciones());
        return dto;
    }

    private Reservation fromDTO(ReservationDTO dto) {
        if (dto == null) return null;
        return new Reservation(dto.getId(), dto.getClienteId(), dto.getFechaInicio(), 
                dto.getFechaFinEstimada(), dto.getFechaCreacion(), dto.getEstadoReservaId(),
                dto.getObservaciones());
    }
}
