package lab3Tingeso.Loa.repositories;

import lab3Tingeso.Loa.entities.notasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notasRepository extends JpaRepository<notasEntity, Long>{

    notasEntity findByCodigoAlumno(int codigoAlumno);
}
