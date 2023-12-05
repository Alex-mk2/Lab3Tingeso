package lab3Tingeso.Loa.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab3Tingeso.Loa.entities.horarioEntity;
import lab3Tingeso.Loa.repositories.horarioRepository;
import lab3Tingeso.Loa.entities.planEntity;
import java.util.ArrayList;
import lab3Tingeso.Loa.repositories.planRepository;

@Service
public class horarioService {

    @Autowired
    private horarioRepository horarioRepository;

    @Autowired
    private planRepository planRepository;


    public ArrayList<horarioEntity> getAllHorarios(){
        return (ArrayList<horarioEntity>) horarioRepository.findAll();
    }

    public horarioEntity crearHorario(horarioEntity horario) {
        String diaSemana = horario.getDiaSemana().toLowerCase();
        if ("sábado".equals(diaSemana) || "domingo".equals(diaSemana)) {
            throw new IllegalArgumentException("Los horarios no están permitidos los sábados ni domingos");
        }
        return horarioRepository.save(horario);
    }

    public horarioEntity buscarHorarioPorBloque(int bloque){
        return horarioRepository.findByBloque(bloque);
    }

    public horarioEntity buscarPorIdHorario(int idHorario){
        return horarioRepository.findByIdHorario(idHorario);
    }

    public ArrayList<horarioEntity> buscarTodosLoshorariosPorCodigoAsignatura(int codigoAsignatura){
        return horarioRepository.findAllHorariosByCodigoAsignatura(codigoAsignatura);
    }

    public horarioEntity buscarPorCodigoAsignatura(int codigoAsignatura){
        return horarioRepository.findByCodigoAsignatura(codigoAsignatura);
    }
    public ArrayList<horarioEntity> buscarCodigoPorPlan(int codigoAsignatura){
        planEntity plan = planRepository.findByCodigoAsignatura(codigoAsignatura);
        if(plan == null){
            return new ArrayList<>();
        }else{
            return horarioRepository.findAllHorariosByCodigoAsignatura(plan.getCodigoAsignatura());
        }
    }
}
