package moviland.com.moviland.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import moviland.com.moviland.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    
}
