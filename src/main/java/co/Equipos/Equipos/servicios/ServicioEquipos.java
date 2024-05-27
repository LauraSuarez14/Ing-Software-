package co.Equipos.Equipos.servicios;

import co.Equipos.Equipos.operaciones.OperacionesEquipo;
import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.entidades.Equipo;
import co.Equipos.Equipos.repositorios.RepoEquipo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ServicioEquipos implements OperacionesEquipo {


    @Autowired
    RepoEquipo repoEquipo ;
    @Autowired
    ModelMapper modelMapper;

    public ServicioEquipos(ModelMapper modelMapper, RepoEquipo repoEquipo) {
        this.modelMapper = modelMapper;
        this.repoEquipo = repoEquipo;
    }

    @Override
    public void crear(EquiposDto equipo) {
        Equipo equipos = modelMapper.map(equipo,Equipo.class);
                repoEquipo.save(equipos);
    }


    @Override
    public List<EquiposDto> consultarT() {
        TypeToken<List<EquiposDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoEquipo.findAll(), typeToken.getType());
    }


    @Override
    public EquiposDto findDtoById(Long id) {
        Equipo equipo = repoEquipo.findById(id).orElse(null);
        return equipo != null ? modelMapper.map(equipo, EquiposDto.class) : null;
    }
}
