package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.carreraEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab3Tingeso.Loa.repositories.carreraRepository;

import java.util.ArrayList;

@Service
public class carreraService {
    @Autowired
    private carreraRepository carreraRepository;

    public ArrayList<carreraEntity> getAllCarreras(){
        return (ArrayList<carreraEntity>) carreraRepository.findAll();
    }

    public carreraEntity createCarrera(carreraEntity carrera){
        return carreraRepository.save(carrera);
    }

    public carreraEntity buscarCarreraPorId(int codigoCarrera){
        return carreraRepository.findByCodigoCarrera(codigoCarrera);
    }
}
