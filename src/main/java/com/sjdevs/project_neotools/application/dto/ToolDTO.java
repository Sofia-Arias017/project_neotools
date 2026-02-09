package com.sjdevs.project_neotools.application.dto;

public class ToolDTO {
    private Long id;
    private String codigoInventario;
    private String nombre;
    private String marca;
    private String modelo;
    private String descripcion;
    private java.time.LocalDateTime fechaAdquisicion;
    private java.math.BigDecimal valorReposicion;
    private String condicionActual;
    private Long proveedorId;
    private Long categoriaId;
    private Long estadoHerramientaId;

    public ToolDTO() {}

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
    public java.math.BigDecimal getValorReposicion() { return valorReposicion; }
    public void setValorReposicion(java.math.BigDecimal valorReposicion) { this.valorReposicion = valorReposicion; }
    public String getCondicionActual() { return condicionActual; }
    public void setCondicionActual(String condicionActual) { this.condicionActual = condicionActual; }
    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    public Long getEstadoHerramientaId() { return estadoHerramientaId; }
    public void setEstadoHerramientaId(Long estadoHerramientaId) { this.estadoHerramientaId = estadoHerramientaId; }
}
