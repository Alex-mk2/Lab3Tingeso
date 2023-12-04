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

    public notasEntity create(notasEntity notas){
        return notasRepository.save(notas);
    }

    public ArrayList<notasEntity> getAllNotas(){
        return (ArrayList<notasEntity>) notasRepository.findAll();
    }

    public notasEntity buscarPorIdNota(int codigoAlumno){
        return notasRepository.findByCodigoAlumno(codigoAlumno);
    }
}
