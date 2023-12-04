package lab3Tingeso.Loa.controllers;
import lab3Tingeso.Loa.entities.estudiantesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "http://localhost:3000")
public class estudiantesController {
    @Autowired
    lab3Tingeso.Loa.services.estudiantesService estudiantesService;

    @GetMapping()
    public ResponseEntity<ArrayList<estudiantesEntity>> getAllEstudents(){
        ArrayList<estudiantesEntity> listaEstudiantes = estudiantesService.obtenerEstudiantes();
        if(listaEstudiantes == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaEstudiantes);
    }

    @PostMapping()
    public ResponseEntity<estudiantesEntity> crearEstudiante(@RequestBody estudiantesEntity estudiantes){
        estudiantesEntity newEstudiante = estudiantesService.guardarEstudiante(estudiantes);
        return ResponseEntity.ok(newEstudiante);
    }

    @GetMapping("/ByCarrera/{codigoCarrera}")
    public ResponseEntity<estudiantesEntity> getByCodigoCarrera(@PathVariable("codigoCarrera") Long codigoCarrera){
        estudiantesEntity estudiante = estudiantesService.findEstudentByCarrer(codigoCarrera);
        if(estudiante == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiante);
    }
}