package com.Fresh.ProyectoFormativo.Service.estudianteServicioIMPL;

import com.Fresh.ProyectoFormativo.Entity.Estudiante;
import com.Fresh.ProyectoFormativo.Repository.estudianteRepo;
import com.Fresh.ProyectoFormativo.Service.estudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class estudianteServicioIMPL implements estudianteServicio {

    @Autowired
    private estudianteRepo repo;



    @Override
    public List<Estudiante> consultarEstudiantes() {
        return (List<Estudiante>) repo.findAll();
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return this.repo.save(estudiante);
    }




    @Override
    public Estudiante modificarEstudiante(Estudiante estudiante) {
        return repo.save(estudiante);
    }


    @Override
    public Estudiante buscarEstudiante(int id) {
        return this.repo.findById(id).get();
    }


}