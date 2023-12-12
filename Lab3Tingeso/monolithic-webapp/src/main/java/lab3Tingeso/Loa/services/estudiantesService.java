package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.estudiantesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class estudiantesService {

    @Autowired
    lab3Tingeso.Loa.repositories.estudiantesRepository estudiantesRepository;
    
    public ArrayList<estudiantesEntity> obtenerEstudiantes(){
        return (ArrayList<estudiantesEntity>) estudiantesRepository.findAll();
    }

    public estudiantesEntity guardarEstudiante(estudiantesEntity usuario){
        return estudiantesRepository.save(usuario);
    }

    public estudiantesEntity findEstudentByCarrer(int codigoCarrera){
        return estudiantesRepository.findEstudentByCodigoCarrera(codigoCarrera);
    }
    public estudiantesEntity deleteEstudentByCarrer(int codigoCarrera){
        return estudiantesRepository.deleteByCodigoCarrera(codigoCarrera);
    }

}