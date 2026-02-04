package com.sjdevs.project_neotools.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inicio")
    private java.time.LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private java.time.LocalDateTime fechaFin;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "herramienta_id")
    private Long herramientaId;

    @Column(name = "estado_reserva_id")
    private Long estadoReservaId;

    public ReservationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.time.LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.time.LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public java.time.LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(java.time.LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }

    public Long getEstadoReservaId() {
        return estadoReservaId;
    }

    public void setEstadoReservaId(Long estadoReservaId) {
        this.estadoReservaId = estadoReservaId;
    }
}
