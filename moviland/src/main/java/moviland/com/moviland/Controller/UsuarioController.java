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
    @GetMapping("/registro")
    private String registro(Model model){
        Usuario usuario= new Usuario();
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    @PostMapping("/registroForm")
    private String registroForm(@ModelAttribute("usuario") Usuario usuario){
        
        Usuario user=usuarioService.buscarPorCorreo(usuario.getCorreo());
        if (user == null) {
            usuarioService.guardarUsuario(usuario);
            return "login";
        } else {
            return "registro";
        }
    }
}
