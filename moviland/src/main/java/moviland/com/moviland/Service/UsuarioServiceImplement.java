package moviland.com.moviland.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImplement implements UsuarioService{
@Autowired
    private UsuarioService usuarioService ;
    @Override
    public boolean confirmarUsuario(String correo, String contraseña) {
        return this.usuarioService.confirmarUsuario(correo, contraseña);
    }
    

}