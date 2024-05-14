package co.Equipos.Equipos.servicios;

import co.Equipos.Equipos.operaciones.OperacionesEquipo;
import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.entidades.Equipo;
import co.Equipos.Equipos.operaciones.OperacionesEquipo;
import co.Equipos.Equipos.repositorios.RepoEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEquipos implements OperacionesEquipo {


    @Autowired
    RepoEquipo repoEquipo ;

    @Override
    public Equipo crear(Equipo equipo) {
        return repoEquipo.save(equipo);
    }

    @Override
    public Equipo actualizar(Equipo equipo) {
        /*if (this.consultarPK(Equipo.getNombre()) != null)
            return repoEquipo.save(equipo);*/
        return null;
    }

    @Override
    public void borrar(Equipo equipo) {
        repoEquipo.delete(equipo);;
    }

    @Override
    public List<Equipo> consultarT() {
        return repoEquipo.findAll();
    }

    @Override
    public Equipo consultarPK(int pk) {
        return repoEquipo.findById((long) pk).orElse(null);

    }

   

}
