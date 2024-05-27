package co.Equipos.Equipos.controlador;

import co.Equipos.Equipos.dto.EquiposDto;

import co.Equipos.Equipos.dto.PartidosDto;
import co.Equipos.Equipos.dto.ResultadosDto;
import co.Equipos.Equipos.entidades.Partido;
import co.Equipos.Equipos.servicios.ServicioEquipos;
import co.Equipos.Equipos.servicios.ServicioPartidos;
import co.Equipos.Equipos.servicios.ServicioResultados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;


@Controller
public class ControladorEquipos {
    @Autowired
    ServicioEquipos servicioEquipos;
    @Autowired
    private ServicioPartidos servicioPartidos;
    @Autowired
    private ServicioResultados servicioResultados;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        return "index";
    }

    @GetMapping("/equipo/lista")
    public String mostrar(Model model){
        List<EquiposDto> listaEquipos = servicioEquipos.consultarT();
        model.addAttribute("listaEquipos", listaEquipos);
        return "lista";
    }

    @GetMapping("/equipo/inscripcion")
    public String cargarEquipoModal(Model model){
        EquiposDto equipoLlenar = new EquiposDto();
        model.addAttribute("equipoLlenar", equipoLlenar);
        return "inscripciones";
    }
    @GetMapping("/equipo/partido")
    public String calendarioPartidos(Model model){
        List<EquiposDto> listaEquipos = servicioEquipos.consultarT();
        model.addAttribute("listaEquipos", listaEquipos);
        List<PartidosDto> listaPartidos = servicioPartidos.consultarT();
        model.addAttribute("listaPartidos", listaPartidos);
        return "partidos";
    }

    @GetMapping("/equipo/resultado")
    public String resultadosPartidos(Model model){
        List<PartidosDto> listaPartidos = servicioPartidos.consultarT();
        model.addAttribute("listaPartidos", listaPartidos);
        return "resultados";
    }

    @GetMapping("/equipo/posiciones")
    public String posicionesPartido(Model model){
        List<EquiposDto> listaEquipos = servicioEquipos.consultarT();
        model.addAttribute("listaEquipos", listaEquipos);
        return "posiciones";
    }

    @PostMapping("/equipo/crear/partido")
    public String crearCalendario(Model model){
        List<Partido> calendario = servicioPartidos.crearCalendario();
        model.addAttribute("calendario", calendario);
        return "redirect:/equipo/partido";
    }

    @PostMapping("/equipo/nuevo")
    public String accioncrear(@ModelAttribute("equipoLlenar") EquiposDto equipo){
        servicioEquipos.crear(equipo);
        return "redirect:/equipo/inscripcion";
    }

    @GetMapping("/equipos/{id}")
    public String mostrarEquipo(@PathVariable Long id, Model model){
        EquiposDto equipo = servicioEquipos.findDtoById(id);
        model.addAttribute("equipo", equipo);
        return "lista";
    }

    @GetMapping("/equipo/partido/{id}/resultado")
    public String mostrarFormularioResultado(@PathVariable Long id, Model model) {
        PartidosDto partido = servicioPartidos.findById(id);
        ResultadosDto resultado = servicioResultados.findById(id);

        model.addAttribute("partido", partido);
        model.addAttribute("resultado", resultado);
        return "agregarResultados";
    }


    @PostMapping("/equipo/partido/resultado")
    public String guardarResultado(@ModelAttribute("resultado") ResultadosDto resultado) {
        servicioResultados.actualizarResultado(resultado);
        return "redirect:/equipo/resultado";
    }
}
