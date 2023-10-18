package moviland.com.moviland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import moviland.com.moviland.Service.CelularService;

@Controller
public class CelularController {
    @Autowired
    private CelularService celularService;

    @GetMapping("/")
    public String verCelulares(Model model){
        model.addAttribute("listaCelular", celularService.getCelulares());
        return "index";
    }

}
