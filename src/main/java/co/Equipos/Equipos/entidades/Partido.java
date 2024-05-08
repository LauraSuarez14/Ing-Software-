package co.Equipos.Equipos.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Partido")
@Table(name = "PARTIDOS")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTIDOS")
    @SequenceGenerator(name = "SEQ_PARTIDOS", sequenceName = "SEQ_PARTIDOS", allocationSize = 1)


    @Column(name = "PAR_ID", nullable = false)
    private int id;

    @Column(name = "PAR_FECHA", nullable = false)
    private String fecha;

    @Column(name = "PAR_LOCAL", nullable = false)
    private String local;

    @Column(name = "PAR_VISITANTE", nullable = false)
    private String visitante;
}