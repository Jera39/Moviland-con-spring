package moviland.com.moviland.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import moviland.com.moviland.Model.Celular;

public interface CelularRepository extends JpaRepository<Celular,String> {
    
}
