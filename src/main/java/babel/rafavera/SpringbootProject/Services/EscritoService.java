package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Escrito;

import java.util.List;

public interface EscritoService {

    /**
     *
     * @param idDocumento
     * @return
     */
    List<Escrito> getEscritoByDocumento(Integer idDocumento);

    /**
     *
     * @param idDocumento
     * @param idAutor
     * @return
     */
    Escrito createEscrito(Integer idDocumento, Integer idAutor);

    /**
     *
     * @param idDocumento
     */
    void deleteByIdDocumento(Integer idDocumento);
}
