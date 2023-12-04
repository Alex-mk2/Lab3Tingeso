package lab3Tingeso.Loa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab3Tingeso.Loa.entities.prerequisitosEntity;
import lab3Tingeso.Loa.repositories.prerequisitosRepository;

import java.util.ArrayList;

@Service
public class prerequisitosService {

    @Autowired
    private prerequisitosRepository prerequisitosRepository;

    public ArrayList<prerequisitosEntity> getAllPrerequisities(){
        return (ArrayList<prerequisitosEntity>) prerequisitosRepository.findAll();
    }

    public prerequisitosEntity findRequisiteById(int codigoPrerequisitos){
        return prerequisitosRepository.findByCodigoPrerequisitos(codigoPrerequisitos);
    }

    public prerequisitosEntity createPrerequisito(prerequisitosEntity prerequisitos){
        return prerequisitosRepository.save(prerequisitos);
    }
}
