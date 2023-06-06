package babel.rafavera.SpringbootProject.Respository;

import babel.rafavera.SpringbootProject.Models.Documento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentoRepository  extends CrudRepository<Documento, Integer> {
    List<Documento> findAll();
}
