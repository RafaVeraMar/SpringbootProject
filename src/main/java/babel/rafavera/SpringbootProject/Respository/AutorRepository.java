package babel.rafavera.SpringbootProject.Respository;

import babel.rafavera.SpringbootProject.Models.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutorRepository extends CrudRepository<Autor, Integer> {

    List<Autor> findAll();

    @Query("SELECT a FROM Autor a JOIN Escrito e ON a.id=e.idAutor WHERE e.idDocumento=:idDocumento")
    List<Autor> findByDocumento(Integer idDocumento);
}
