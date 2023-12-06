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

    public horarioEntity crearHorario(horarioEntity horario){
        horarioEntity horario1 = horarioRepository.findDiaByDiaSemana(horario.getDiaSemana());
        if ("sabado".equals(horario1) || "domingo".equals(horario1)) {
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

    public horarioEntity buscarPorDia(String diaSemana){
        return horarioRepository.findDiaByDiaSemana(diaSemana);
    }

}
