package moviland.com.moviland.Service;

import java.util.List;
import java.util.Optional;

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
        return celularRepository.findByEstadoTrue();
        
        
    }
    @Override
    public void nuevoCelular(Celular celular) {
        this.celularRepository.save(celular);
    }   

    @Override
    public Celular buscarCelular(int id) {
        Optional<Celular> opcional = celularRepository.findById(String.valueOf(id));
		Celular celular=null;
		if(opcional.isPresent()) {
			celular = opcional.get();
		}else {
			throw new RuntimeException("No existe celular con este ID: "+ id);
		}
		return celular;
    }
    @Override
    public void desabilitarCelular(int id, Boolean estado) {
        this.celularRepository.updateEstado(id, estado);
    }
    
    
}
