package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Escrito;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EscritoServiceImpl implements EscritoService{


    @Override
    public List<Escrito> getEscritoByDocumento(Integer idDocumento) {
        return null;
    }

    @Override
    public Escrito createEscrito(Integer idDocumento, Integer idAutor) {
        return null;
    }

    @Override
    public void deleteByIdDocumento(Integer idDocumento) {

    }
}
