package com.sjdevs.project_neotools.domain.model;

public class Tool {
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

    public Tool() {
    }

    public Tool(Long id, String codigoInventario, String nombre, String marca, String modelo, 
            String descripcion, java.time.LocalDateTime fechaAdquisicion, java.math.BigDecimal valorReposicion, 
            String condicionActual, Long proveedorId, Long categoriaId, Long estadoHerramientaId) {
        this.id = id;
        this.codigoInventario = codigoInventario;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.fechaAdquisicion = fechaAdquisicion;
        this.valorReposicion = valorReposicion;
        this.condicionActual = condicionActual;
        this.proveedorId = proveedorId;
        this.categoriaId = categoriaId;
        this.estadoHerramientaId = estadoHerramientaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.time.LocalDateTime getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(java.time.LocalDateTime fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public java.math.BigDecimal getValorReposicion() {
        return valorReposicion;
    }

    public void setValorReposicion(java.math.BigDecimal valorReposicion) {
        this.valorReposicion = valorReposicion;
    }

    public String getCondicionActual() {
        return condicionActual;
    }

    public void setCondicionActual(String condicionActual) {
        this.condicionActual = condicionActual;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getEstadoHerramientaId() {
        return estadoHerramientaId;
    }

    public void setEstadoHerramientaId(Long estadoHerramientaId) {
        this.estadoHerramientaId = estadoHerramientaId;
    }
}
