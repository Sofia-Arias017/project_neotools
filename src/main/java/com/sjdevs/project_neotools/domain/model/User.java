package com.sjdevs.project_neotools.domain.model;

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String estado;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime lastLogin;

    public User() {}

    public User(Long id, String username, String email, String password, String estado, java.time.LocalDateTime createdAt, java.time.LocalDateTime lastLogin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.estado = estado;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
    public java.time.LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(java.time.LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
}
