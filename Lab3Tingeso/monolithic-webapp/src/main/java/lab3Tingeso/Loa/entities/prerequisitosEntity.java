package lab3Tingeso.Loa.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prerequisitos")
public class prerequisitosEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int cod_prereq; //Codigo prerequisitos
    private int cod_asig; //Codigo asignatura
}
