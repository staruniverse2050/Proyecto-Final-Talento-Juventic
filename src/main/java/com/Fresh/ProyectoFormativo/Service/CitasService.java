package com.Fresh.ProyectoFormativo.Service;
import com.Fresh.ProyectoFormativo.Entity.Citas;

import java.util.List;

public interface CitasService {
    List<Citas> ConsultarCitas();
    Citas CrearCita(Citas citas);
    Citas ModificarCita(Citas citas);
    Citas BuscarCita(int id);
    void CancelarCita(int id);
}