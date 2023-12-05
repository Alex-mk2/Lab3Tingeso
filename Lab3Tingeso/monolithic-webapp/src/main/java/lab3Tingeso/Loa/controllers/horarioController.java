package lab3Tingeso.Loa.controllers;
import lab3Tingeso.Loa.entities.horarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab3Tingeso.Loa.services.horarioService;

import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping("/horarios")
@CrossOrigin(origins = "http://localhost:3000")
public class horarioController{

    @Autowired
    private horarioService horarioService;


    @GetMapping()
    public ResponseEntity<ArrayList<horarioEntity>> getAllHorarios(){
        ArrayList<horarioEntity> Horarios = horarioService.getAllHorarios();
        if(Horarios == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Horarios);
    }

    @PostMapping()
    public ResponseEntity<?> crearHorario(@RequestBody horarioEntity horario) {
        String diaSemana = horario.getDiaSemana().toLowerCase();
        if("sábado".equals(diaSemana) || "domingo".equals(diaSemana)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Los horarios no están permitidos los sábados ni domingos"));
        }
        horarioEntity newHorario = horarioService.crearHorario(horario);
        return ResponseEntity.ok(newHorario);
    }


    @GetMapping("/ByBloque/{bloque}")
    public ResponseEntity<horarioEntity> getBloques(@PathVariable("bloque") int bloque){
        horarioEntity horario = horarioService.buscarHorarioPorBloque(bloque);
        if(horario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(horario);
    }

    @GetMapping("/ByIdHorario/{idHorario}")
    public ResponseEntity<horarioEntity> getHorario(@PathVariable("idHorario") int idHorario){
        horarioEntity horario = horarioService.buscarPorIdHorario(idHorario);
        if(horario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(horario);
    }

    @GetMapping("/ByCodigoAsignatura/{codigoAsignatura}")
    public ResponseEntity<horarioEntity> getHorarioByCodigoAsignatura(@PathVariable("codigoAsignatura") int codigoAsignatura){
        horarioEntity horario = horarioService.buscarPorCodigoAsignatura(codigoAsignatura);
        if(horario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(horario);
    }

    @GetMapping("/plan/{codigoAsignatura}")
    public ResponseEntity<ArrayList<horarioEntity>> buscarTodosPorCodigoPlan(@PathVariable("codigoAsignatura") int codigoAsignatura){
        ArrayList<horarioEntity> listaHorarios = horarioService.buscarCodigoPorPlan(codigoAsignatura);
        if(listaHorarios == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaHorarios);
    }
}
