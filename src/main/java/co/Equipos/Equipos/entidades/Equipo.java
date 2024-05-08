package co.Equipos.Equipos.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Equipo")
@Table(name = "EQUIPOS")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EQUIPOS")
    @SequenceGenerator(name = "SEQ_EQUIPOS", sequenceName = "SEQ_EQUIPOS", allocationSize = 1)


    @Column(name = "EQU_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EQU_UNIFORME", nullable = false)
    private String uniforme;

    @Column(name = "EQU_TECNICO", nullable = false)
    private String tecnico;

    @Column(name = "EQU_DIRECCION", nullable = false)
    private String direccion;
}