package co.Equipos.Equipos.operaciones;




import co.Equipos.Equipos.dto.PartidosDto;
import co.Equipos.Equipos.dto.ResultadosDto;
import co.Equipos.Equipos.entidades.Resultado;

import java.util.List;

public interface OperacionesResultado {
    void crear(Resultado resultado);
    public List<ResultadosDto> consultarT();
    void actualizarResultado(PartidosDto partidoDto);
}
