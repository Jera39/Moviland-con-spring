package moviland.com.moviland.Service;

import moviland.com.moviland.Model.Usuario;

public interface UsuarioService {
    Usuario confirmarUsuario(String correo,String contraseñaString);
    void guardarUsuario(Usuario usuario);
    Usuario buscarPorCorreo(String correo);
}
