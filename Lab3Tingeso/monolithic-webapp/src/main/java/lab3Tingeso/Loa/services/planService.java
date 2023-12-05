package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.planEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class planService {

    @Autowired
    private lab3Tingeso.Loa.repositories.planRepository planRepository;

    public planEntity crearPlanEstudiante(planEntity plan){
        return planRepository.save(plan);
    }

    public ArrayList<planEntity> getAllPlans(){
      return (ArrayList<planEntity>) planRepository.findAll();
    }

    public planEntity buscarPlanPorId(int codigoPlan){
        return planRepository.findByCodigoPlan(codigoPlan);
    }

    public planEntity buscarCodigoAsignatura(int codigoAsignatura){
        return planRepository.findByCodigoAsignatura(codigoAsignatura);
    }
    public ArrayList<planEntity> buscarCodigosAsignaturas(int codigoAsignatura){
        return planRepository.findListByCodigoAsignatura(codigoAsignatura);
    }
}
