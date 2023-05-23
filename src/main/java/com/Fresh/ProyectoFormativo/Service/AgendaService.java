package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Agenda;

import java.util.List;

public interface AgendaService {
    public List<Agenda> ConsultarAgendas();
    public Agenda CrearAgenda(Agenda agenda);
    public Agenda ModificarAgenda(Agenda agenda);
    public Agenda BuscarAgenda(int id);
    public void EliminarAgenda(int id);
}
