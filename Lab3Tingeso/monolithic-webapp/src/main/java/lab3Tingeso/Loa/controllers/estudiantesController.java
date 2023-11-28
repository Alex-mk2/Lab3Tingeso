package lab3Tingeso.Loa.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/estudiantes")
@CrossOrigin("*")
public class estudiantesController {
    @Autowired
    lab3Tingeso.Loa.services.estudiantesService estudiantesService;

}