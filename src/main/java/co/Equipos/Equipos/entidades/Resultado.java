package co.Equipos.Equipos.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Resultado")
@Table(name = "RESULTADOS")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESULTADOS")
    @SequenceGenerator(name = "SEQ_RESULTADOS", sequenceName = "SEQ_RESULTADOS", allocationSize = 1)


    @Column(name = "RES_ID", nullable = false)
    private long id;

    @Column(name = "RES_GOLL", nullable = false)
    private int golL;

    @Column(name = "RES_GOLV", nullable = false)
    private int golV;

    @Column(name = "RES_JUGADORGOL", nullable = false)
    private String jugadorGol;

    @Column(name = "RES_AUTOGOL", nullable = false)
    private boolean autogol;

    @Column(name = "RES_MINUTO", nullable = false)
    private int minuto;

    @ManyToOne
    @JoinColumn(name = "PAR_LOCAL")
    private Partido local;

    @ManyToOne
    @JoinColumn(name = "PAR_VISITANTE")
    private Partido visitante;
}