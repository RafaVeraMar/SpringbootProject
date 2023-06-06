package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;

import java.util.List;

public interface DocumentoFacade {
    /**
     *
     * @return
     */
    List<DocumentoResponse> obtenerDocumentos();

    /**
     *
     * @param id
     * @return
     */
    DocumentoResponse obtenerDocumento(Integer id);

    /**
     *
     * @param documentoRequest
     * @return
     */
    DocumentoResponse crearDocumento(DocumentoRequest documentoRequest);

    /**
     * @param id
     * @param documentoRequest
     * @return
     */
    DocumentoResponse editarDocumento(Integer id, DocumentoRequest documentoRequest);

    /**
     *
     * @param id
     * @return
     */
    DocumentoResponse eliminarDocumento(Integer id);
}
