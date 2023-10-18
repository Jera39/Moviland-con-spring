package moviland.com.moviland.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moviland.com.moviland.Model.Celular;
import moviland.com.moviland.Repository.CelularRepository;
@Service
public class CelularServiceImplement implements CelularService {
    @Autowired
    private CelularRepository celularRepository;
    @Override
    public List<Celular> getCelulares() {

        return celularRepository.findAll();
        
    }
    
    
}
