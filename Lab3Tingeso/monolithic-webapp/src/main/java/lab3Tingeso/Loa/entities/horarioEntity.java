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
    private int bloque; //Bloque de cada asignatura (bloque 1, bloque 2...)
    private int codigoAsignatura;
    private String diaSemana;
    private int horaInicio;
    private int horaTermino;
    private String nombreAsignatura;
}
