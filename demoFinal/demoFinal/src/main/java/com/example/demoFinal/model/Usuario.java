package com.example.demoFinal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
    private Integer id;


    @Column(name="usua_nombre")
    private String nombre;


    @Column(name= "usua_email")
    private String email;


    @OneToMany
    private List<Tarea1> tareas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tarea1> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea1> tareas) {
        this.tareas = tareas;
    }
}
