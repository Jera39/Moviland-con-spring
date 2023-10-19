package moviland.com.moviland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import moviland.com.moviland.Model.Usuario;
import moviland.com.moviland.Service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "login";
    }

    @PostMapping("/autentificar")
    private String autentificar(@ModelAttribute("usuario") Usuario usuario){
        
        Usuario user=usuarioService.confirmarUsuario(usuario.getCorreo(), usuario.getContraseña());
        if(user == null){
            return "login";
        }else{
            return "index";

        }
    }
}
