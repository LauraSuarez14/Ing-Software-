package co.Equipos.Equipos.operaciones;

import java.util.List;
public interface OperacionesEquipo {
    public List<EstudiantesDto> listar();
    public void ingresar(EstudiantesDto estudiante);

}
