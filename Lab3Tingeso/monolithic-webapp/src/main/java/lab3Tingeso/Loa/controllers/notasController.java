package lab3Tingeso.Loa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lab3Tingeso.Loa.entities.notasEntity;
import lab3Tingeso.Loa.services.notasService;

import java.util.ArrayList;

@RestController
@RequestMapping("/notas")
@CrossOrigin(origins = "http://localhost:3000")
public class notasController{
    @Autowired
    private notasService notasService;

    @GetMapping()
    public ResponseEntity<ArrayList<notasEntity>> getAllNotas(){
        ArrayList<notasEntity> notas = notasService.getAllNotas();
        if(notas == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notas);
    }

    @PostMapping()
    public ResponseEntity<notasEntity> crearNotas(@RequestBody notasEntity notas){
        notasEntity newNotas = notasService.create(notas);
        return ResponseEntity.ok(newNotas);
    }
}
