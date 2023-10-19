package moviland.com.moviland.Service;

import moviland.com.moviland.Model.Celular;
import java.util.List;
public interface CelularService {
    List<Celular> getCelulares();
    void nuevoCelular(Celular celular);
    Celular buscarCelular(int id);
    void desabilitarCelular(int id, Boolean estado);
}
