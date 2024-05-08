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
    private String nombre;
}