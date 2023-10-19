package moviland.com.moviland.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moviland.com.moviland.Model.Usuario;
import moviland.com.moviland.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImplement implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario confirmarUsuario(String correo, String contraseña) {
        Optional<Usuario> opcional = usuarioRepository.findByCorreoAndContraseña(correo, contraseña);
        return opcional.orElse(null); // Retorna el usuario si existe, o null si no se encontró uno.
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
       

    
}
