package co.Equipos.Equipos.entidades;


import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Equipo")
@Table(name = "EQUIPOS")
@Builder
@ToString
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Column(name = "EQU_ID", nullable = false)
    private long id;

    @Column(name = "EQU_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EQU_UNIFORME", nullable = false)
    private String uniforme;

    @Column(name = "EQU_TECNICO", nullable = false)
    private String tecnico;

    @Column(name = "EQU_DIRECCION", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "EST_NOMBRE")
    private Estadio estadio;


}