package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.Respository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EditorialServiceImpl implements EditorialService{

    private EditorialRepository repository;
    @Autowired
    public EditorialServiceImpl(EditorialRepository repository) {
        this.repository = repository;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public List<Editorial> getEditoriales() {
        return null;
    }

    @Override
    public Editorial getEditorial(Integer id) {
        return null;
    }

    @Override
    public Editorial createEditorial(String editorial) {
        return null;
    }

    @Override
    public Editorial setEditorial(Integer id, String editorial) {
        return null;
    }

    @Override
    public Editorial deleteEditorial(Integer id) {
        return null;
    }
}
