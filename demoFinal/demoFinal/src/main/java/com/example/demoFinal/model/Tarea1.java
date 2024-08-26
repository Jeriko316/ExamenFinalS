package com.example.demoFinal.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="tarea1")
public class Tarea1 {

    @Id
    @Column(name ="tare_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarea")
    @SequenceGenerator(name = "seq_tarea", sequenceName = "seq_tarea", allocationSize = 1)
    private String id;

    @Column(name="tare_titulo")
    private String titulo;

    @Column(name="tare_descripcion")
    private String descripcion;

    @Column(name="tare_fecha")
    private LocalDateTime fechaCreacion;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tare_id_usua")
    private Usuario usuario;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
