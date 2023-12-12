package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.notasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab3Tingeso.Loa.repositories.notasRepository;

import java.util.ArrayList;

@Service
public class notasService{

    @Autowired
    private notasRepository notasRepository;

    @Autowired
    private estudiantesService estudiantesService;
    public notasEntity create(notasEntity notas){
        return notasRepository.save(notas);
    }

    public ArrayList<notasEntity> getAllNotas(){
        return (ArrayList<notasEntity>) notasRepository.findAll();
    }

    public notasEntity buscarPorCodigoAlumno(int codigoAlumno){
        return notasRepository.findByCodigoAlumno(codigoAlumno);
    }

    public notasEntity buscarPorCodigoAsignatura(int codigoAsignatura){
        return notasRepository.findByCodigoAsignatura(codigoAsignatura);
    }

    public notasEntity buscarNota(int nota){
        return notasRepository.findByNota(nota);
    }

    public int verificarCondicionNota(int nota){
        notasEntity notas = notasRepository.findByNota(nota);
        if(notas == null) {
            return -3; //No existe la nota
        }
        if(notas.getNota() < 3){
            return -2; //Significa que reprobaste el ramo
        }
        if(notas.getNota() > 4){
            return 1; //Cumple con el requerimiento
        }
        return nota;
    }
}
