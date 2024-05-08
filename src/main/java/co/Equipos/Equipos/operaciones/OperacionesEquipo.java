package co.Equipos.Equipos.operaciones;

import co.Equipos.Equipos.dto.EquiposDto;

import java.util.List;
public interface OperacionesEquipo {
    public List<EquiposDto> listar();
    public void ingresar(EquiposDto equipo);

}
