package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Respository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutorServiceImpl implements AutorService {

    private AutorRepository autorRepository;

    @Autowired
    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> getAutores() {
        final List<Autor> autores = autorRepository.findAll();
        return autores;
    }

    @Override
    public Autor getAutor(Integer id) {
        final Autor autor = autorRepository.findById(id).orElse(new Autor());
        return autor;
    }

    @Override
    public Autor editAutor(Integer id, String nombre) {
        Autor autor = getAutor(id);
        if (autor.getId()!=null) {
            autor.setNombre(nombre);
            autor = autorRepository.save(autor);
        }
        return autor;
    }

    @Override
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor deleteAutor(Integer id) {
        final Autor autor = getAutor(id);
        if (autor.getId()!=null) {
            autorRepository.delete(autor);
        }
        return autor;
    }

    @Override
    public List<Autor> getAutoresByDocumento(Integer idDocumento) {
        return autorRepository.findByDocumento(idDocumento);
    }

}
