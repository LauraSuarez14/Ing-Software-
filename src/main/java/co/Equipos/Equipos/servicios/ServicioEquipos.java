package co.Equipos.Equipos.servicios;

import co.Equipos.Equipos.operaciones.OperacionesEquipo;
import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.entidades.Equipo;
import co.Equipos.Equipos.operaciones.OperacionesEquipo;
import co.Equipos.Equipos.repositorios.RepoEquipo;
import org.Equipos.Equipos.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEquipos implements OperacionesEquipo {

    @Autowired
    RepoEquipo repoEquipos;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EquiposDto> listar() {
        TypeToken<List<EquipoDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoEquipos.findAll(),typeToken.getType());

    }

    @Override
    public void ingresar(EquipoDto docente) {
        Docente docentes = modelMapper.map(docente,Docente.class);
        repoDocentes.save(docentes);

    }

}
