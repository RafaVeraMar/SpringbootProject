package babel.rafavera.SpringbootProject.Respository;

import babel.rafavera.SpringbootProject.Models.Documento;
import babel.rafavera.SpringbootProject.Models.Editorial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EditorialRepository extends CrudRepository<Editorial, Integer > {
    List<Editorial> findAll();
}
