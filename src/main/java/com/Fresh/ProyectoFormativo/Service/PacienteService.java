package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface PacienteService {
    public List<Paciente> ConsultarPaciente();
    public Paciente CrearPaciente(Paciente paciente);
    public Paciente ModificarPaciente(Paciente paciente);
    public Paciente BuscarPaciente(int id);
    public void EliminarPaciente(int id);

}
