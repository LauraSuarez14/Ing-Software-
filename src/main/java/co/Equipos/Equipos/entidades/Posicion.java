package co.Equipos.Equipos.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Posicion")
@Table(name = "POCISIONES")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POCISIONES")
    @SequenceGenerator(name = "SEQ_POCISIONES", sequenceName = "SEQ_POCISIONES", allocationSize = 1)


    @Column(name = "POS_PJ", nullable = false)
    private int pj;

    @Column(name = "POS_PP", nullable = false)
    private int pp;

    @Column(name = "POS_PE", nullable = false)
    private int pe;

    @Column(name = "POS_PG", nullable = false)
    private int pg;

    @Column(name = "POS_GF", nullable = false)
    private int gf;

    @Column(name = "POS_GC", nullable = false)
    private int gc;

    @Column(name = "POS_GD", nullable = false)
    private int gd;

    @Column(name = "POS_PUNTOS", nullable = false)
    private int puntos;
}