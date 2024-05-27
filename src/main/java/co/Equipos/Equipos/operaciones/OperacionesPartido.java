package co.Equipos.Equipos.operaciones;

import co.Equipos.Equipos.entidades.Partido;
import co.Equipos.Equipos.dto.PartidosDto;

import java.util.List;

public interface OperacionesPartido {
    public Partido crear(Partido partido);
    public List<Partido> consultarT();
    public Partido consultarPK(int id);
    public String crearCalendario();
}
