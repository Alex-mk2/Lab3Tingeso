package lab3Tingeso.Loa.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horario")
public class horarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idHorario;
    @Column(nullable = false)
    private int bloque; //Bloque de cada asignatura (bloque 1, bloque 2...)
    @Column(nullable = false)
    private int codigoAsignatura;
    @Column(nullable = false)
    private String diaSemana;
    @Column(nullable = false)
    private int horaInicio;
    @Column(nullable = false)
    private int horaTermino;
    @Column(nullable = false)
    private String nombreAsignatura;
}
