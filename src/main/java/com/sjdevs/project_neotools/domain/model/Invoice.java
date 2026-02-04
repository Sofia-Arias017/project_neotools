package com.sjdevs.project_neotools.domain.model;

public class Invoice {
    private Long id;
    private String numeroFactura;
    private java.time.LocalDateTime fechaEmision;
    private java.math.BigDecimal total;
    private Long pagoId;

    public Invoice() {
    }

    public Invoice(Long id, String numeroFactura, java.time.LocalDateTime fechaEmision, java.math.BigDecimal total,
            Long pagoId) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.pagoId = pagoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public java.time.LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(java.time.LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public java.math.BigDecimal getTotal() {
        return total;
    }

    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }

    public Long getPagoId() {
        return pagoId;
    }

    public void setPagoId(Long pagoId) {
        this.pagoId = pagoId;
    }
}
