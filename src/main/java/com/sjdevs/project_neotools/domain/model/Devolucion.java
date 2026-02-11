package com.sjdevs.project_neotools.domain.model;

import java.security.Timestamp;

public class Devolucion {
    private Long id;
    private String descripcion;
    private Double costoReparacion;
    private Timestamp fechaReparacion;

    public Devolucion() {
    }

    public Devolucion(Long id, String descripcion, Double costoReparacion, Timestamp fechaReparacion) {
        this.id=id;
        this.descripcion=descripcion;
        this.costoReparacion=costoReparacion;
        this.fechaReparacion=fechaReparacion;
    }

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
}