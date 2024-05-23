package co.Equipos.Equipos.servicios;

import co.Equipos.Equipos.operaciones.OperacionesEquipo;
import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.entidades.Equipo;
import co.Equipos.Equipos.repositorios.RepoEquipo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public void crearCalendario() {
        List<EquiposDto> equipos = consultarT();
        int numEquipos = equipos.size();
        if (numEquipos % 2 != 0) {
            throw new IllegalArgumentException("El número de equipos debe ser par.");
        }

        List<String> calendario = new ArrayList<>();

        int numRondas = numEquipos - 1;

        for (int ronda = 0; ronda < numRondas; ronda++) {
            calendario.add("Ronda " + (ronda + 1));

            for (int i = 0; i < numEquipos / 2; i++) {
                int equipoLocal = (ronda + i) % (numEquipos - 1);
                int equipoVisitante = (numEquipos - 1 - i + ronda) % (numEquipos - 1);


                if (i == 0) {
                    equipoVisitante = numEquipos - 1;
                }

                calendario.add(equipos.get(equipoLocal).getNombre() + " vs " + equipos.get(equipoVisitante).getNombre());
            }
        }


        /*for (String partido : calendario) {
            System.out.println(partido);
        }*/
    }
}
