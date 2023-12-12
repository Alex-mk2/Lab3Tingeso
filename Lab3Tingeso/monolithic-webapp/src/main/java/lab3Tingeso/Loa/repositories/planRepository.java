package lab3Tingeso.Loa.repositories;
import lab3Tingeso.Loa.entities.planEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface planRepository extends JpaRepository<planEntity, Long>{

    planEntity findByCodigoPlan(int codigoPlan);

    planEntity findByCodigoAsignatura(int codigoAsignatura);

    int findByNivel(int nivel);

    ArrayList<planEntity> findListByCodigoAsignatura(int codigoAsignatura);
}
