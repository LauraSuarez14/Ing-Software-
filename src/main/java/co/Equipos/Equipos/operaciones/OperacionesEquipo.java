package co.Equipos.Equipos.operaciones;

import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.entidades.Equipo;

import java.util.List;
public interface OperacionesEquipo {
    public Equipo crear(Equipo equipo);
    public Equipo actualizar(Equipo equipo);
    public void borrar(Equipo quipo);
    public List<Equipo> consultarT();
    public Equipo consultarPK(int pk);
}
