package moviland.com.moviland.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import moviland.com.moviland.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    @Query("SELECT u FROM Usuario WHERE correo = :correo AND contraseña = :contraseña")
    Usuario findByCorreoAndContraseña(@Param("correo") String correo, @Param("contraseña") String contraseña);
}
