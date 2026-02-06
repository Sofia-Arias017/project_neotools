package com.sjdevs.project_neotools.domain.model;

public class Payment {
    private Long id;
    private Long reservaId;
    private java.math.BigDecimal monto;
    private java.time.LocalDateTime fechaPago;
    private String metodoPago;
    private Long estadoPagoId;

    public Payment() {
    }

    public Payment(Long id, Long reservaId, java.math.BigDecimal monto, java.time.LocalDateTime fechaPago,
            String metodoPago, Long estadoPagoId) {
        this.id = id;
        this.reservaId = reservaId;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estadoPagoId = estadoPagoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public java.math.BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(java.math.BigDecimal monto) {
        this.monto = monto;
    }

    public java.time.LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(java.time.LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Long getEstadoPagoId() {
        return estadoPagoId;
    }

    public void setEstadoPagoId(Long estadoPagoId) {
        this.estadoPagoId = estadoPagoId;
    }
}
