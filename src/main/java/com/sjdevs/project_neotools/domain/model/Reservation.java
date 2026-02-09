package com.sjdevs.project_neotools.domain.model;

public class Reservation {
    private Long id;
    private Long clienteId;
    private Long herramientaId;
    private java.time.LocalDateTime fechaInicio;
    private java.time.LocalDateTime fechaFinEstimada;
    private java.time.LocalDateTime fechaCreacion;
    private Long estadoReservaId;
    private String observaciones;

    public Reservation() {
    }

    public Reservation(Long id, Long clienteId, java.time.LocalDateTime fechaInicio, 
            java.time.LocalDateTime fechaFinEstimada, java.time.LocalDateTime fechaCreacion, 
            Long estadoReservaId, String observaciones) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.fechaCreacion = fechaCreacion;
        this.estadoReservaId = estadoReservaId;
        this.observaciones = observaciones;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getEstadoReservaId() {
        return estadoReservaId;
    }

    public void setEstadoReservaId(Long estadoReservaId) {
        this.estadoReservaId = estadoReservaId;
    }
}