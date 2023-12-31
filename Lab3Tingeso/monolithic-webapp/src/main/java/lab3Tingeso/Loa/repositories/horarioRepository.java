package lab3Tingeso.Loa.repositories;
import lab3Tingeso.Loa.entities.horarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface horarioRepository extends JpaRepository<horarioEntity, Long>{
    horarioEntity findByBloque(int bloque);

    horarioEntity findByIdHorario(int idHorario);

    horarioEntity findDiaByDiaSemana(String diaSemana);
}
