package co.Equipos.Equipos.servicios;

import co.Equipos.Equipos.dto.PartidosDto;
import co.Equipos.Equipos.dto.ResultadosDto;
import co.Equipos.Equipos.entidades.Partido;
import co.Equipos.Equipos.entidades.Resultado;
import co.Equipos.Equipos.repositorios.RepoPartido;
import co.Equipos.Equipos.repositorios.RepoResultado;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioResultados {
    @Autowired
    RepoPartido repoPartido;
    @Autowired
    RepoResultado repoResultado;
    @Autowired
    ModelMapper modelMapper;

    public Resultado crear(Resultado resultado){
        return repoResultado.save(resultado);
    }

    public List<ResultadosDto> consultarT(){
        TypeToken<List<ResultadosDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoResultado.findAll(), typeToken.getType());
    }

    public void actualizarResultado(ResultadosDto resultadosDto) {
        Resultado resultado = modelMapper.map(resultadosDto, Resultado.class);
        repoResultado.save(resultado);
    }

    public ResultadosDto findById(Long id) {
        Resultado resultado = repoResultado.findById(id).orElseThrow(() -> new IllegalArgumentException("Resultado no jugado"));
        return modelMapper.map(resultado, ResultadosDto.class);
    }
}
