package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.web.dto.request.AutorRequest;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;

import java.util.List;

public interface AutorFacade {

    /**
     * Obtener todos los autores
     * @return List<AutorResponse>
     */
    List<AutorResponse> getAutores();

    /**
     * Obtener autor por id
     * @param id
     * @return AutorResponse
     */
    AutorResponse getAutor(Integer id);

    /**
     *
     * @param id
     * @param autorRequest
     * @return AutorResponse
     */
    AutorResponse editAutor(Integer id, AutorRequest autorRequest);

    /**
     *
     * @param autorRequest
     * @return
     */
    AutorResponse crearAutor(AutorRequest autorRequest);

    /**
     *
     * @param id
     * @return
     */
    AutorResponse eliminarAutor(Integer id);
}
