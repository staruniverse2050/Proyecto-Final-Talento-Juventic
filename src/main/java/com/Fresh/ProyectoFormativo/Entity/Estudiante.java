package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "estudiante")
@Data
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identificacion_estudiante")
    private int identificacion_estudiante;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "grado")
    private String grado;

    @Column(name = "calificacion")
    private BigDecimal calificacion;

    @Column(name = "estado_nota")
    private String estado_nota;

    @Column(name = "estado")
    private boolean Estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdentificacion_estudiante() {
        return identificacion_estudiante;
    }

    public void setIdentificacion_estudiante(int identificacion_estudiante) {
        this.identificacion_estudiante = identificacion_estudiante;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstado_nota() {
        return estado_nota;
    }

    public void setEstado_nota(String estado_nota) {
        this.estado_nota = estado_nota;
    }

    public Estudiante() {
        this.Estado = true;
    }

    public String getEstado() {
        if (Estado) {
            return "Activo";
        } else {
            return "Innactivo";
        }
    }
    public boolean setEstado() {
        this.Estado = Estado;
        return false;
    }
}