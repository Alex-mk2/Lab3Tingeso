package lab3Tingeso.Loa.controllers;
import lab3Tingeso.Loa.services.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
@RequestMapping("/estudiantes")
@CrossOrigin("*")
public class EstudiantesController {
    @Autowired
    EstudiantesService estudiantesService;

}