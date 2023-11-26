package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.EstudiantesEntity;
import lab3Tingeso.Loa.repositories.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudiantesService{

    @Autowired
    EstudiantesRepository estudiantesRepository;
    
    public ArrayList<EstudiantesEntity> obtenerUsuarios(){
        return (ArrayList<EstudiantesEntity>) estudiantesRepository.findAll();
    }

    public EstudiantesEntity guardarUsuario(EstudiantesEntity usuario){
        return estudiantesRepository.save(usuario);
    }

    public Optional<EstudiantesEntity> obtenerPorId(Long id){
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