package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.estudiantesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class estudiantesService {

    @Autowired
    lab3Tingeso.Loa.repositories.estudiantesRepository estudiantesRepository;
    
    public ArrayList<estudiantesEntity> obtenerUsuarios(){
        return (ArrayList<estudiantesEntity>) estudiantesRepository.findAll();
    }

    public estudiantesEntity guardarUsuario(estudiantesEntity usuario){
        return estudiantesRepository.save(usuario);
    }

    public Optional<estudiantesEntity> obtenerPorId(Long id){
        return estudiantesRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            estudiantesRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
  
}