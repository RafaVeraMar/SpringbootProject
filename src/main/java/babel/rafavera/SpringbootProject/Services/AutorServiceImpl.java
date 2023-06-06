package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Respository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorServiceImpl implements AutorService{

private AutorRepository repository;

    @Override
    public List<Autor> getAutores() {
        return null;
    }

    @Override
    public Autor getAutor(Integer id) {
        return null;
    }

    @Override
    public Autor createAutor(Autor autor) {
        return null;
    }

    @Override
    public Autor editAutor(Integer id, String nombre) {
        return null;
    }

    @Override
    public Autor deleteAutor(Integer id) {
        return null;
    }

    @Override
    public List<Autor> getAutoresByDocumento(Integer idDocumento) {
        return null;
    }
}
