package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int id_cita;

    @Column(name = "id_pacientecita")
    private int id_paciente;

    @Column(name = "id_administradorcita")
    private int id_administrador;

    @Column(name = "fecha_cita")
    private Date fecha_cita;

    @Column(name = "hora_cita")
    private LocalDate hora_cita;

    @Column(name = "tipo_cita")
    private String tipo_cita;

    @Column(name = "estado")
    private String estado;
    @Column(name = "sede")
    private String sede;

    @Column(name = "costo")
    private BigDecimal costo;

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public LocalDate getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(LocalDate hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
