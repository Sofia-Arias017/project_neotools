package com.sjdevs.project_neotools.infrastructure.controller;

import com.sjdevs.project_neotools.application.service.ReservationService;
import com.sjdevs.project_neotools.application.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.saveOrUpdateReservation(reservationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        reservationDTO.setId(id);
        return ResponseEntity.ok(reservationService.saveOrUpdateReservation(reservationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(reservationService.getReservationsByCliente(clienteId));
    }

    @GetMapping("/estado/{estadoId}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByEstado(@PathVariable Long estadoId) {
        return ResponseEntity.ok(reservationService.getReservationsByEstado(estadoId));
    }
}
