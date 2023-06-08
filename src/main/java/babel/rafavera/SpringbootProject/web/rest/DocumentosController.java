package babel.rafavera.SpringbootProject.web.rest;


import babel.rafavera.SpringbootProject.Facades.DocumentoFacade;
import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/documentos")
public class DocumentosController {
    private DocumentoFacade facade;

    @Autowired
    public DocumentosController(DocumentoFacade facade) {
        this.facade=facade;

    }

    /**
     *
     * @return
     * Getting a list of documents
     * Defined as final because this list will be definitive and the object will be stored the less time needed in memory
     * to get XML instead JSON -> @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
     * to get JSON instead XML -> @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     * By default @GetMapping retrieves JSON mediatype
     */

    @GetMapping
    public ResponseEntity<List<DocumentoResponse>> obtenerDocumentos() {
        final List<DocumentoResponse> documentos = facade.obtenerDocumentos();
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }

    @GetMapping("/{idDocumento}")
    public ResponseEntity<DocumentoResponse> obtenerDocumento(@PathVariable Integer idDocumento) {
        final DocumentoResponse documento = facade.obtenerDocumento(idDocumento);
        return new ResponseEntity<DocumentoResponse>(documento,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DocumentoResponse> crearDocumento(@RequestBody DocumentoRequest body){
        final DocumentoResponse documento = facade.crearDocumento(body);
        return new ResponseEntity<DocumentoResponse>(documento, HttpStatus.OK);
    }

    // TODO: editar atributos de un documento
    // TODO: eliminar un documento

}
