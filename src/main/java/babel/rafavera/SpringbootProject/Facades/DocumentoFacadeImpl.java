package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.Mappers.DocumentoMapper;
import babel.rafavera.SpringbootProject.Models.Documento;
import babel.rafavera.SpringbootProject.Services.AutorService;
import babel.rafavera.SpringbootProject.Services.DocumentosService;
import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class DocumentoFacadeImpl implements DocumentoFacade{

    private DocumentosService docService;
    private AutorService autorService;
    private DocumentoMapper docMapper;
    @Autowired
    public DocumentoFacadeImpl(DocumentosService docService, AutorService autorService, DocumentoMapper docMapper) {
        this.docService = docService;
        this.autorService = autorService;
        this.docMapper = docMapper;
    }


    @Override
    public List<DocumentoResponse> obtenerDocumentos() {
        final List<Documento> documentos = docService.getDocumentos();

        return documentos.stream().map(doc -> docMapper.toDtoResp(doc, autorService.getAutoresByDocumento(doc.getId()))).toList();
    }

    @Override
    public DocumentoResponse obtenerDocumento(Integer id) {
        return null;
    }

    @Override
    public DocumentoResponse crearDocumento(DocumentoRequest documentoRequest) {
        return null;
    }

    @Override
    public DocumentoResponse editarDocumento(Integer id, DocumentoRequest documentoRequest) {
        return null;
    }

    @Override
    public DocumentoResponse eliminarDocumento(Integer id) {
        return null;
    }
}
