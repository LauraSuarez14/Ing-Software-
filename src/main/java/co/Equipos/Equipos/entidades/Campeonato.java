package co.Equipos.Equipos.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Campeonato")
@Table(name = "CAMPEONATOS")
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAMPEONATOS")
    @SequenceGenerator(name = "SEQ_CAMPEONATOS", sequenceName = "SEQ_CAMPEONATOS", allocationSize = 1)

    @Column(name = "CAM_CODIGO", nullable = false)
    private long serial ;

    @Column(name = "CAM_NOMBRE", nullable = false)
    private String nombre;

}