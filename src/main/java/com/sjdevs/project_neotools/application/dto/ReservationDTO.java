package com.sjdevs.project_neotools.application.dto;

public class ReservationDTO {
    private Long id;
    private java.time.LocalDateTime fechaInicio;
    private java.time.LocalDateTime fechaFin;
    private Long clienteId;
    private Long herramientaId;
    private Long estadoReservaId;

    public ReservationDTO() {
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
