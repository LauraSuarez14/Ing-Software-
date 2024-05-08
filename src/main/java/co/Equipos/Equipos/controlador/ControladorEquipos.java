package co.Equipos.Equipos.controlador;

import co.ucentral.gestionador.de.notas.servicios.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorEquipos {
    @Autowired
    ServicioEquipos servEquipo;

    @GetMapping("/")
    public String inicio(){
        return "redirect:/equipos/lista";
    }

    @GetMapping("/estudiantes/lista")
    public String mostrar(Model model){
        model.addAttribute("equipo",servEquipo.listar());
        return "equipos";
    }
}
