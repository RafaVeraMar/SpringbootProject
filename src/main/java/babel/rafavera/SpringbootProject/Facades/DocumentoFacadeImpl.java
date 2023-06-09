package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.Mappers.DocumentoMapper;
import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Models.Documento;
import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.Services.AutorService;
import babel.rafavera.SpringbootProject.Services.DocumentosService;
import babel.rafavera.SpringbootProject.Services.EditorialService;
import babel.rafavera.SpringbootProject.Services.EscritoService;
import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class DocumentoFacadeImpl implements DocumentoFacade{

    private DocumentosService docService;
    private AutorService autorService;
    private EditorialService editorialService;
    private EscritoService escritoService;
    private DocumentoMapper docMapper;
    @Autowired
    public DocumentoFacadeImpl(DocumentosService docService, AutorService autorService, EditorialService editorialService, EscritoService escritoService, DocumentoMapper docMapper) {
        this.docService = docService;
        this.editorialService = editorialService;
        this.autorService = autorService;
        this.escritoService = escritoService;
        this.docMapper = docMapper;
    }


    @Override
    public List<DocumentoResponse> obtenerDocumentos() {
        final List<Documento> documentos = docService.getDocumentos();

        return documentos.stream().map(doc -> docMapper.toDtoResp(doc, autorService.getAutoresByDocumento(doc.getId()))).toList();
    }

    @Override
    public DocumentoResponse obtenerDocumento(Integer id) {
        final Documento documento = docService.getDocumento(id);
        return docMapper.toDtoResp(documento,autorService.getAutoresByDocumento(id));
    }

    @Override
    public DocumentoResponse crearDocumento(DocumentoRequest documentoRequest) {
        final Editorial editorial = editorialService.getEditorial(documentoRequest.getEditorial());
        final Documento documento = docService.createDocumento(docMapper.toEntity(documentoRequest,editorial));

        final List<Autor> autores = new ArrayList<>();
        documentoRequest.getAutores().forEach(id -> {
            final Autor autor = autorService.getAutor(id);
            if (autor.getId()!=null) {
                escritoService.createEscrito(documento.getId(),autor.getId());
                autores.add(autor);
            }
        });
        return docMapper.toDtoResp(documento,autores);
    }

    @Override
    public DocumentoResponse editarDocumento(Integer id, DocumentoRequest documentoRequest) {

        final Editorial editorial = editorialService.getEditorial(documentoRequest.getEditorial());
        final Documento documento = docService.editDocumento(id, docMapper.toEntity(documentoRequest,editorial));

        final List<Autor> autores = new ArrayList<>();
        if (documento.getId() != null) {
            List<Integer> autoresIds = documentoRequest.getAutores();
            if (!CollectionUtils.isEmpty(autoresIds)) {
                autoresIds.forEach(autorid -> {
                    final Autor autor = autorService.getAutor(autorid);
                    if (autor.getId() != null) {
                        escritoService.createEscrito(documento.getId(), autor.getId());
                        autores.add(autor);
                    }
                });
            } else {
                autores.addAll(autorService.getAutoresByDocumento(id));
            }
        }
        return docMapper.toDtoResp(documento, autores);
    }

    @Override
    public DocumentoResponse eliminarDocumento(Integer id) {
        final List<Autor> autores = autorService.getAutoresByDocumento(id);
        final Documento doc = docService.deleteDocumento(id);
        return docMapper.toDtoResp(doc,null);

    }
}
