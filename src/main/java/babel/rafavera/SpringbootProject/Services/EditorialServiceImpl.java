package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.Respository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EditorialServiceImpl implements EditorialService {

    private EditorialRepository repository;

    @Autowired
    public EditorialServiceImpl(EditorialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Editorial> getEditoriales() {
        return repository.findAll();
    }

    @Override
    public Editorial getEditorial(Integer id) {
        return repository.findById(id).orElse(new Editorial());
    }

    @Override
    public Editorial createEditorial(String editorial) {
        final Editorial e = new Editorial();
        e.setNombre(editorial);
        return repository.save(e);
    }

    @Override
    public Editorial setEditorial(Integer id, String editorial) {
        Editorial e = getEditorial(id);
        if (e.getId()!=null) {
            e.setNombre(editorial);
            e = repository.save(e);
        }
        return e;
    }

    @Override
    public Editorial deleteEditorial(Integer id) {
        final Editorial editorial = getEditorial(id);
        if (editorial.getId()!=null) {
            repository.deleteById(id);
        }
        return editorial;
    }

}
