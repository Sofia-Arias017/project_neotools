package com.sjdevs.project_neotools.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "fecha_pago")
    private java.time.LocalDateTime fechaPago;

    @Column(name = "reserva_id")
    private Long reservaId;

    @Column(name = "estado_pago_id")
    private Long estadoPagoId;

    public PaymentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public java.time.LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(java.time.LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getEstadoPagoId() {
        return estadoPagoId;
    }

    public void setEstadoPagoId(Long estadoPagoId) {
        this.estadoPagoId = estadoPagoId;
    }
}
