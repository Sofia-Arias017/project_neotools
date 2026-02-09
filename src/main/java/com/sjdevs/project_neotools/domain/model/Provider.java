package com.sjdevs.project_neotools.domain.model;

public class Provider {
    private Long id;
    private String empresa;
    private String telefono;
    private String estado;
    private Long usuarioId;

    public Provider() {}

    public Provider(Long id, String empresa, String telefono, String estado, Long usuarioId) {
        this.id = id;
        this.empresa = empresa;
        this.telefono = telefono;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
