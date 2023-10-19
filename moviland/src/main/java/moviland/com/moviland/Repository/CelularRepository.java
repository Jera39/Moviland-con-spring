package moviland.com.moviland.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import moviland.com.moviland.Model.Celular;

public interface CelularRepository extends JpaRepository<Celular, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Celular SET estado = :estado WHERE id = :id", nativeQuery = true)
    void updateEstado(@Param("id") int id, @Param("estado") Boolean estado);



    List<Celular> findByEstadoTrue();
}
