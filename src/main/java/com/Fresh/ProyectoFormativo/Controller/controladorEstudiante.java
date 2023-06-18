package com.Fresh.ProyectoFormativo.Controller;
import com.Fresh.ProyectoFormativo.Entity.Estudiante;
import com.Fresh.ProyectoFormativo.Repository.estudianteRepo;
import com.Fresh.ProyectoFormativo.Service.estudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ProyectoFinal/Estudiante")
public class controladorEstudiante {

    @Autowired
    private estudianteServicio estudianteServicio;

    @Autowired
    private estudianteRepo estudianteRepo;

    @GetMapping("/ConsultarEstudiantes")
    public ResponseEntity<List<Estudiante>> consultarEstudiantes() {
        List<Estudiante> estudiantesActivos = estudianteServicio.consultarEstudiantes();
        return ResponseEntity.ok(estudiantesActivos);
    }

    @PostMapping("/CrearEstudiante")
    public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante) {
        BigDecimal calificacion = estudiante.getCalificacion();

        if (calificacion.compareTo(BigDecimal.ONE) < 0 || calificacion.compareTo(BigDecimal.valueOf(5.0)) > 0) {
            String mensaje = "Nota inválida. La calificación debe estar en el rango de 1 a 5.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }

        if (calificacion.compareTo(BigDecimal.valueOf(3.0)) < 0) {
            estudiante.setEstado_nota("Reprobado");
        } else {
            estudiante.setEstado_nota("Aprobado");
        }

        Estudiante created = estudianteServicio.crearEstudiante(estudiante);
        String mensaje = "Estudiante creado exitosamente"; // Mensaje de éxito
        Map<String, Object> response = new HashMap<>();
        response.put("created", created);
        response.put("message", mensaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/ModificarEstudiante")
    public ResponseEntity<?> modificarEstudiante(@RequestBody Estudiante estudiante) {
        BigDecimal calificacion = estudiante.getCalificacion();

        if (calificacion.compareTo(BigDecimal.valueOf(5.0)) > 0) {
            String mensaje = "Nota inválida. La calificación debe ser menor o igual a 5.0";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }

        if (estudiante.getEstado_nota() == null) {
            if (calificacion.compareTo(BigDecimal.valueOf(3.0)) < 0) {
                estudiante.setEstado_nota("Reprobado");
            } else {
                estudiante.setEstado_nota("Aprobado");
            }
        }

        Estudiante estudianteModificado = estudianteServicio.modificarEstudiante(estudiante);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Estudiante modificado con éxito.");
        response.put("estudianteModificado", estudianteModificado);
        return ResponseEntity.ok(response);
    }



    @PutMapping("/ActivarEstudiante/{id}")
    public ResponseEntity<?> activarEstudiante(@PathVariable Long id) {
        Optional<Estudiante> estudianteOptional = Optional.ofNullable(estudianteRepo.findById(id));

        if (estudianteOptional.isEmpty()) {
            String mensaje = "No se encontró el estudiante con el ID proporcionado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }

        Estudiante estudiante = estudianteOptional.get();
        estudiante.setEstado(true);
        Estudiante activado = estudianteRepo.save(estudiante);

        String mensaje = "Estudiante activado exitosamente";
        Map<String, Object> response = new HashMap<>();
        response.put("activado", activado);
        response.put("message", mensaje);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/BuscarEstudiante/{id}")
    public ResponseEntity<?> buscarEstudiante(@PathVariable int id) {
        Optional<Estudiante> estudianteOptional = estudianteRepo.findById(id);

        if (!estudianteOptional.isPresent()) {
            String mensaje = "No se encontró el estudiante con el ID proporcionado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }

        Estudiante estudiante = estudianteOptional.get();
        return ResponseEntity.ok(estudiante);
    }

    @DeleteMapping("/DesactivarEstudiante/{id}")
    public ResponseEntity<String> desactivarEstudiante(@PathVariable int id) {
        Optional<Estudiante> estudianteOptional = estudianteRepo.findById(id);

        if (!estudianteOptional.isPresent()) {
            String mensaje = "No se encontró el estudiante con el ID proporcionado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }

        Estudiante estudianteDesactivado = estudianteOptional.get();
        estudianteDesactivado.setEstado(false);
        Estudiante estudianteActualizado = estudianteRepo.save(estudianteDesactivado);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Estudiante desactivado con éxito");
        response.put("estudianteDesactivado", estudianteActualizado);

        return ResponseEntity.ok().body(response.toString());
    }
}




