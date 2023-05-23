package com.Fresh.ProyectoFormativo.Service.CitasServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Repository.CitasRepo;
import com.Fresh.ProyectoFormativo.Service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasServiceIMPL implements CitasService {

    private final CitasRepo repo;

    @Autowired
    public CitasServiceIMPL(CitasRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Citas> ConsultarCitas() {
        return (List<Citas>) this.repo.findAll();
    }


    @Override
    public Citas CrearCita(Citas cita) {
        return repo.save(cita);
    }

    @Override
    public Citas ModificarCita(Citas cita) {
        return repo.save(cita);
    }

    @Override
    public Citas BuscarCita(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
    }

    @Override
    public void CancelarCita(int id) {
        repo.deleteById(id);
    }
}
