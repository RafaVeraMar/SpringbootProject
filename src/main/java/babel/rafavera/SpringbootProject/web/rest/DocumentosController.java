package babel.rafavera.SpringbootProject.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca/documentos")
public class DocumentosController {
    private DocumentoFacade facade;

    @Autowired
    public DocumentsController(DocumentoFacade facade) {
        this.facade=facade;

    }

    // TODO: Obtener listado de documentos
    // TODO: obtener un documento por ID
    // TODO: crear un nuevo documento
    // TODO: editar atributos de un documento
    // TODO: eliminar un documento

}
