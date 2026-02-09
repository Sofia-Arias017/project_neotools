package com.sjdevs.project_neotools.domain.model;

public class Client {
    private Long id;
    private String documento;
    private String telefono;
    private Long usuarioId;

    public Client() {}

    public Client(Long id, String documento, String telefono, Long usuarioId) {
        this.id = id;
        this.documento = documento;
        this.telefono = telefono;
        this.usuarioId = usuarioId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
