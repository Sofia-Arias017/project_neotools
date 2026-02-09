package com.sjdevs.project_neotools.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;

@Entity
@Table(name = "herramienta")
public class ToolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_inventario")
    private String codigoInventario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_adquisicion")
    private java.time.LocalDateTime fechaAdquisicion;

    @Column(name = "valor_reposicion")
    private BigDecimal valorReposicion;

    @Column(name = "condicion_actual")
    private String condicionActual;

    @Column(name = "proveedor_id")
    private Long proveedorId;

    @Column(name = "categoria_id")
    private Long categoriaId;

    @Column(name = "estado_herramienta_id")
    private Long estadoHerramientaId;

    public ToolEntity() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigoInventario() { return codigoInventario; }
    public void setCodigoInventario(String codigoInventario) { this.codigoInventario = codigoInventario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public java.time.LocalDateTime getFechaAdquisicion() { return fechaAdquisicion; }
    public void setFechaAdquisicion(java.time.LocalDateTime fechaAdquisicion) { this.fechaAdquisicion = fechaAdquisicion; }
    public BigDecimal getValorReposicion() { return valorReposicion; }
    public void setValorReposicion(BigDecimal valorReposicion) { this.valorReposicion = valorReposicion; }
    public String getCondicionActual() { return condicionActual; }
    public void setCondicionActual(String condicionActual) { this.condicionActual = condicionActual; }
    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    public Long getEstadoHerramientaId() { return estadoHerramientaId; }
    public void setEstadoHerramientaId(Long estadoHerramientaId) { this.estadoHerramientaId = estadoHerramientaId; }
}
