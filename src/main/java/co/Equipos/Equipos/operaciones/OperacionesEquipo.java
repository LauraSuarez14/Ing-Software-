package co.Equipos.Equipos.operaciones;

import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.entidades.Equipo;

import java.util.List;
public interface OperacionesEquipo {

    void crear(EquiposDto equipo);
    public List<EquiposDto> consultarT();
    EquiposDto findDtoById(Long id);

}
