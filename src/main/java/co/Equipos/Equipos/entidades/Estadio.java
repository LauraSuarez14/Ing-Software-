package co.Equipos.Equipos.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Estadio")
@Table(name = "ESTADIOS")
public class Estadio{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADIOS")
    @SequenceGenerator(name = "SEQ_ESTADIOS", sequenceName = "SEQ_ESTADIOS", allocationSize = 1)


    @Column(name = "EST_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EST_CAPACIDAD", nullable = false)
    private String capacidad;
}
