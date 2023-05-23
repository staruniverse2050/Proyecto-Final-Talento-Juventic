package com.Fresh.ProyectoFormativo.Service.AgendaServiceIMPL;
import com.Fresh.ProyectoFormativo.Entity.Administrador;
import com.Fresh.ProyectoFormativo.Entity.Agenda;
import com.Fresh.ProyectoFormativo.Repository.AgendaRepo;
import com.Fresh.ProyectoFormativo.Service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceIMPL implements AgendaService {
    @Autowired
    private AgendaRepo repo;

    @Override
    public List<Agenda> ConsultarAgendas() {
        return (List<Agenda>) this.repo.findAll();
    }

    @Override
    public Agenda CrearAgenda(Agenda agenda) {
        agenda.setNumero_documento(agenda.getNumero_documento());
        return this.repo.save(agenda);
    }

    @Override
    public Agenda ModificarAgenda(Agenda agenda) {
        return this.repo.save(agenda);
    }

    @Override
    public Agenda BuscarAgenda(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarAgenda(int id) {
        this.repo.deleteById(id);
    }
}