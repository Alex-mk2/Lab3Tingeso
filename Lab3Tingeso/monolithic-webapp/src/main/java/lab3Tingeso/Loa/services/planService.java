package lab3Tingeso.Loa.services;
import lab3Tingeso.Loa.entities.planEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import lab3Tingeso.Loa.services.estudiantesService;
import lab3Tingeso.Loa.entities.estudiantesEntity;
import lab3Tingeso.Loa.entities.notasEntity;
import lab3Tingeso.Loa.entities.prerequisitosEntity;
import lab3Tingeso.Loa.services.prerequisitosService;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class planService {

    @Autowired
    private lab3Tingeso.Loa.repositories.planRepository planRepository;

    @Autowired
    private estudiantesService estudiantesService;

    @Autowired
    private notasService notasService;

    @Autowired
    private prerequisitosService prerequisitosService;

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

    public int obtenerNivelRamos(int nivel){
        return planRepository.findByNivel(nivel);
    }

    public ArrayList<planEntity> buscarRamosPorPlan(int codigoAsignatura){
        return planRepository.findListByCodigoAsignatura(codigoAsignatura);
    }

}
