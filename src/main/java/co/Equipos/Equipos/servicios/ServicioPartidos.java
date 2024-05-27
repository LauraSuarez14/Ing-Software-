package co.Equipos.Equipos.servicios;

import co.Equipos.Equipos.dto.EquiposDto;
import co.Equipos.Equipos.dto.PartidosDto;
import co.Equipos.Equipos.entidades.Partido;
import co.Equipos.Equipos.repositorios.RepoEquipo;
import co.Equipos.Equipos.repositorios.RepoPartido;
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
public class ServicioPartidos {

    @Autowired
    RepoPartido repoPartido;
    @Autowired
    RepoEquipo repoEquipo ;
    @Autowired
    ModelMapper modelMapper;

    public Partido crear(Partido partido){
        return repoPartido.save(partido);
    }

    public List<PartidosDto> consultarT(){
        TypeToken<List<PartidosDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoPartido.findAll(), typeToken.getType());
    }

    public List<Partido> crearCalendario() {
        List<Partido> partidos = new ArrayList<>();
        List<EquiposDto> equipos = modelMapper.map(repoEquipo.findAll(), new TypeToken<List<EquiposDto>>() {}.getType());
        int numEquipos = equipos.size();
        if (numEquipos % 2 != 0) {
            throw new IllegalArgumentException("El número de equipos debe ser par.");
        }


        int numRondas = numEquipos - 1;

        for (int ronda = 0; ronda < numRondas; ronda++) {
            for (int i = 0; i < numEquipos / 2; i++) {
                int equipoLocal = (ronda + i) % (numEquipos - 1);
                int equipoVisitante = (numEquipos - 1 - i + ronda) % (numEquipos - 1);

                if (i == 0) {
                    equipoVisitante = numEquipos - 1;
                }

                Partido partido = new Partido();
                partido.setLocal(equipos.get(equipoLocal).getNombre());
                partido.setVisitante(equipos.get(equipoVisitante).getNombre());
                partido.setFecha(generarFechaAleatoria());
                partidos.add(partido);
            }
        }
        repoPartido.saveAll(partidos);
        return partidos;
}

    public String generarFechaAleatoria() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2024, 6, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2024, 12, 30).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return randomDate.format(formatter);
    }

    public PartidosDto findById(Long id) {
        Partido partido = repoPartido.findById(id).orElseThrow(() -> new IllegalArgumentException("Partido no encontrado"));
        return modelMapper.map(partido, PartidosDto.class);
    }
    }