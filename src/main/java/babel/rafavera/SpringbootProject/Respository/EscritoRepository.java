package babel.rafavera.SpringbootProject.Respository;

import babel.rafavera.SpringbootProject.Models.Escrito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EscritoRepository extends CrudRepository<Escrito, Integer> {

    @Query("SELECT e FROM Escrito e WHERE e.idDocumento=:idDocumento")
    List<Escrito> findByDocumento(Integer idDocumento);

   // estas son dos maneras de modificar el escrito
   // 	@Modifying
//	@Query("DELETE FROM Escrito e WHERE e.idDocumento=:idDocumento")
    @Transactional
    void deleteByIdDocumento(Integer idDocumento);
}