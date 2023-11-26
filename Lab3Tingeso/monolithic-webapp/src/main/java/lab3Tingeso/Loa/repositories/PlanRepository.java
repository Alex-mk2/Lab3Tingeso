package lab3Tingeso.Loa.repositories;

import lab3Tingeso.Loa.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long>{

}
