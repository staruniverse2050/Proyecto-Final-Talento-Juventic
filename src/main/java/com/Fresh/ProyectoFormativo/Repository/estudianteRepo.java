package com.Fresh.ProyectoFormativo.Repository;


import com.Fresh.ProyectoFormativo.Entity.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface estudianteRepo extends CrudRepository<Estudiante, Integer> {
    Estudiante findById(Long id);
}