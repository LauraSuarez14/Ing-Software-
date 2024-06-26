package co.Equipos.Equipos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString

public class EquiposDto implements Serializable{

    private long id;

    private String direccion;

    private String nombre;

    private String tecnico;

    private String uniforme;
}
