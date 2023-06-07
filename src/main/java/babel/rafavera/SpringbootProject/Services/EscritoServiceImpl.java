package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Escrito;
import babel.rafavera.SpringbootProject.Respository.EscritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EscritoServiceImpl implements EscritoService {

    private EscritoRepository repository;

    @Autowired
    public EscritoServiceImpl(EscritoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Escrito> getEscritoByDocumento(Integer idDocumento) {
        return repository.findByDocumento(idDocumento);
    }

    @Override
    public Escrito createEscrito(Integer idDocumento, Integer idAutor) {
        final Escrito escrito = new Escrito();
        escrito.setIdDocumento(idDocumento);
        escrito.setIdAutor(idAutor);
        return repository.save(escrito);
    }

    @Override
    public void deleteByIdDocumento(Integer idDocumento) {
        repository.deleteByIdDocumento(idDocumento);
    }

}
