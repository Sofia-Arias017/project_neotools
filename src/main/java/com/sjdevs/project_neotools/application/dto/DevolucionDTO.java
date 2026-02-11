package com.sjdevs.project_neotools.application.dto;

public class DevolucionDTO {
    private Long id;
    private String estado;
    private String descripcionDano;
    private Double costoReparacion;
    private Timestamp fechaReparacion;

    public DevolucionDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcionDano;
    }

    public void setDescripcionDano(String descripcionDano) {
        this.descripcionDano = descripcionDano;
    }

    public Double getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(Double costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public Timestamp getFechaReparacion() {
        return costoReparación;
    }

    public void setDescripcion(Timestamp fechaReparacion) {
        this.fechaReparacion=fechaReparacion;
    }
}
