package lab3Tingeso.Loa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "plan")
public class PlanEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int cod_carr;
    private int cod_plan;
    private int nivel;
    private int cod_asig;
    private String nombreAsignatura;
}
