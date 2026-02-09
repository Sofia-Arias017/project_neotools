package com.sjdevs.project_neotools.application.dto;

public class PaymentDTO {
    private Long id;
    private Long reservaId;
    private String concepto;
    private java.math.BigDecimal monto;
    private java.time.LocalDateTime fechaPago;
    private Long estadoPagoId;

    public PaymentDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }
    public String getConcepto() { return concepto; }
    public void setConcepto(String concepto) { this.concepto = concepto; }
    public java.math.BigDecimal getMonto() { return monto; }
    public void setMonto(java.math.BigDecimal monto) { this.monto = monto; }
    public java.time.LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(java.time.LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
    public Long getEstadoPagoId() { return estadoPagoId; }
    public void setEstadoPagoId(Long estadoPagoId) { this.estadoPagoId = estadoPagoId; }
}
