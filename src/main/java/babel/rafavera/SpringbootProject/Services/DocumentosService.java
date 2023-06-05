package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Documento;

import java.util.List;

public interface DocumentosService {

    /**
     *
     * @return List<Documento>
     */
    List<Documento> getDocumentos();

    /**
     *
     * @param id
     * @return Documento
     */
    Documento getDocumento(Integer id);

    /**
     *
     * @param documento
     * @return Documento
     */
    Documento createDocumento(Documento documento);

    /**
     *
     * @param id
     * @param doc
     * @return Documento
     */
    Documento editDocumento(Integer id, Documento doc);

    /**
     *
     * @param id
     * @return Documento
     */
    Documento deleteDocumento(Integer id);
}
