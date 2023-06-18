package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Estudiante;

import java.util.List;

public interface estudianteServicio {
    List<Estudiante> consultarEstudiantes();
    Estudiante crearEstudiante(Estudiante estudiante);
    Estudiante modificarEstudiante(Estudiante estudiante);
    Estudiante buscarEstudiante(int id);

}