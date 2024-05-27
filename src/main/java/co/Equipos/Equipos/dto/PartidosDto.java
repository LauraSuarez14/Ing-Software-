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

public class PartidosDto implements Serializable{

    private long id;

    private String fecha;

    private String local;

    private String visitante;

}
