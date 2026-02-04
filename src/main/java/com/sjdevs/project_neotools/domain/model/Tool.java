package com.sjdevs.project_neotools.domain.model;

public class Tool {
    private Long id;
    private String nombre;
    private String descripcion;
    private java.math.BigDecimal precioDia;
    private java.time.LocalDateTime createdAt;
    private Long proveedorId;
    private Long estadoHerramientaId;
    private Long categoriaId;

    public Tool() {
    }

    public Tool(Long id, String nombre, String descripcion, java.math.BigDecimal precioDia,
            java.time.LocalDateTime createdAt, Long proveedorId, Long estadoHerramientaId, Long categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDia = precioDia;
        this.createdAt = createdAt;
        this.proveedorId = proveedorId;
        this.estadoHerramientaId = estadoHerramientaId;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.math.BigDecimal getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(java.math.BigDecimal precioDia) {
        this.precioDia = precioDia;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getEstadoHerramientaId() {
        return estadoHerramientaId;
    }

    public void setEstadoHerramientaId(Long estadoHerramientaId) {
        this.estadoHerramientaId = estadoHerramientaId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
