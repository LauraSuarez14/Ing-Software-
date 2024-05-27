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

public class ResultadosDto implements Serializable{

    private long id;

    private int golL;

    private int golV;

    private String jugadorGol;

    private boolean autogol;

    private int minuto;

    private String local;

    private String visitante;

}
