package lab3Tingeso.Loa.repositories;
import lab3Tingeso.Loa.entities.CarreraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, Long>{

}
