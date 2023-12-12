package lab3Tingeso.Loa.repositories;

import lab3Tingeso.Loa.entities.prerequisitosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface prerequisitosRepository extends JpaRepository<prerequisitosEntity, Long>{

    prerequisitosEntity findByCodigoPrerequisitos(int codigoPrerequisitos);

    ArrayList<prerequisitosEntity> findListByCodigoAsignatura(int codigoAsignatura);
}
