package com.sjdevs.project_neotools.infrastructure.persistence.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ReporteDano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costoReparacion")
    private Double costoReparacion;

    @Column(name = "fechaReparacion")
    private Timestamp fechaReparacion;

    @Column(name = "reserva_id")
    private Long reservaId;

    public ReporteDano() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(Double costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public Timestamp getFechaReparacion() {
        return fechaReparacion;
    }

    public void setFechaReparacion(Timestamp fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }
}
