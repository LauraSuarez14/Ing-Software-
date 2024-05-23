package co.Equipos.Equipos.controlador;

import co.Equipos.Equipos.dto.EquiposDto;

import co.Equipos.Equipos.servicios.ServicioEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ControladorEquipos {
    @Autowired
    ServicioEquipos servicioEquipos;

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
        return "partidos";
    }

    @PostMapping("/equipo/crear/partido")
    public String crearCalendario(Model model){
        servicioEquipos.crearCalendario();
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
}
