package lab3Tingeso.Loa.repositories;
import lab3Tingeso.Loa.entities.carreraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carreraRepository extends JpaRepository<carreraEntity, Long>{

    carreraEntity findByCodigoCarrera(int codigoCarrera);
}
