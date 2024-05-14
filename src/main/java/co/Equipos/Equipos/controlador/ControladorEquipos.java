package co.Equipos.Equipos.controlador;

import co.Equipos.Equipos.entidades.Equipo;
import co.Equipos.Equipos.entidades.Estadio;
import co.Equipos.Equipos.servicios.ServicioEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControladorEquipos {
    @Autowired
    ServicioEquipos servicioEquipos;

    @GetMapping("/")
    public String inicio(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/mostrar")
    public String mostrar(Model model){
        model.addAttribute("listaEquipos",servicioEquipos.consultarT());

        for (Equipo elequipo : servicioEquipos.consultarT()){
            System.out.println( elequipo);
        }
        //System.out.println("Paso por aca");
        return "lista";
    }

    @GetMapping({  "/equipo/nuevo"})
    public String cargarEquipoModal(Model model){
        Equipo equipo = new Equipo();
        Estadio estadio = new Estadio();

        equipo.setEstadio(estadio);
        model.addAttribute("equipo",equipo);
        //model.addAttribute("listapropietarios",this.serviciosPropietario.consultarT());


        System.out.println("Paso por aca formulario");
        return "inscripciones";
    }

    @PostMapping({"/accioncrear"})
    public String accioncrear(@ModelAttribute("equipo") Equipo equipo){
        System.out.println("Paso por aca para guardar formulario");
        System.out.println(equipo);

        /*Propietario p = Propietario
                .builder()
                .identificacion(carro.getPropietario().getIdentificacion())
                .nombre(carro.getPropietario().getNombre())
                .build();

        Carro carro1 = Carro
                .builder()
                .modelo(carro.getModelo())
                .placa(carro.getPlaca())
                .build();


        List<Carro> lista = new ArrayList<>();

        lista.add(carro1);


        Propietario p1 =  serviciosPropietario.crear(p);
        System.out.println("++++++ "+p1);
        */


        this.servicioEquipos.crear(equipo);
        return "redirect:/equipo/lista";
    }



    public void crearEquipo(Equipo equipo){
        servicioEquipos.crear(equipo);
    }

    public Equipo buscarEquipo(int pk){
        Equipo equipo = servicioEquipos.consultarPK(pk);
        return null;
    }
}
