package lab3Tingeso.Loa.repositories;
import lab3Tingeso.Loa.entities.EstudiantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiantesRepository extends JpaRepository<EstudiantesEntity, Long> {

}