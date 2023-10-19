package moviland.com.moviland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import moviland.com.moviland.Model.Celular;
import moviland.com.moviland.Service.CelularService;

@Controller
public class CelularController {
    @Autowired
    private CelularService celularService;
    
    @GetMapping("/presentacion")
    public String presentacion(Model model, @CookieValue(name = "username", required = false) String username) {
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }
        return "index";
    }

    @GetMapping("/catalogo")
    public String verCelulares(Model model){
        model.addAttribute("listaCelular", celularService.getCelulares());
        return "catalogo";
    }

    @GetMapping("/registroCelularForm")
    public String registrarCelularForm(Model model){
        Celular celular = new Celular();
        model.addAttribute("Celular", celular);
        return "nuevoCelular";
    }
    @PostMapping("guardarCelular")
	public String guardarCelular(@ModelAttribute("Celular") Celular celular) {
		celular.setEstado(true);
		celularService.nuevoCelular(celular);
		return "redirect:/catalogo";
	}

    @GetMapping("/actualizarCelular/{id}")
	public String actualizarEmpleado(@PathVariable(value="id")int id, Model modelo) {
		//Obtener el empleado desde el servicio
		Celular celular = celularService.buscarCelular(id);
		modelo.addAttribute("Celular", celular);
		return "actualizarCatalogo";
	}

    @GetMapping("/desabilitarCelular/{id}")
	public String desabilitarCelular(@PathVariable(value="id")int id) {
		this.celularService.desabilitarCelular(id, false);
		return "redirect:/catalogo";
	}

}
