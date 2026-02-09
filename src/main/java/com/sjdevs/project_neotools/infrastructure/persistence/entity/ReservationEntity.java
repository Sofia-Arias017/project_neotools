package com.sjdevs.project_neotools.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "reserva")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "herramienta_id")
    private Long herramientaId;

    @Column(name = "fecha_inicio")
    private java.time.LocalDateTime fechaInicio;

    @Column(name = "fecha_fin_estimada")
    private java.time.LocalDateTime fechaFinEstimada;

    @Column(name = "fecha_creacion")
    private java.time.LocalDateTime fechaCreacion;

    @Column(name = "estado_reserva_id")
    private Long estadoReservaId;

    @Column(name = "observaciones")
    private String observaciones;

    public ReservationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public java.time.LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.time.LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public java.time.LocalDateTime getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public void setFechaFinEstimada(java.time.LocalDateTime fechaFinEstimada) {
        this.fechaFinEstimada = fechaFinEstimada;
    }

    public java.time.LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(java.time.LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getEstadoReservaId() {
        return estadoReservaId;
    }

    public void setEstadoReservaId(Long estadoReservaId) {
        this.estadoReservaId = estadoReservaId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
