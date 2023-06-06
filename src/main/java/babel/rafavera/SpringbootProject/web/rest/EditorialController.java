package babel.rafavera.SpringbootProject.web.rest;

import babel.rafavera.SpringbootProject.Facades.EditorialFacade;
import babel.rafavera.SpringbootProject.web.dto.request.EditorialRequest;
import babel.rafavera.SpringbootProject.web.dto.response.EditorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/editoriales")
public class EditorialController {

    private EditorialFacade facade;

    @Autowired
    public EditorialController(EditorialFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<EditorialResponse>> obtenerEditoriales() {
        final List<EditorialResponse> editoriales = facade.getEditoriales();
        return new ResponseEntity<List<EditorialResponse>>(editoriales, HttpStatus.OK);
    }

    @GetMapping("/{idEditorial}")
    public ResponseEntity<EditorialResponse> obtenerEditorial(@PathVariable Integer idEditorial) {
        final EditorialResponse editorial = facade.getEditorial(idEditorial);
        return new ResponseEntity<EditorialResponse>(editorial, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EditorialResponse> crearEditorial(@RequestBody EditorialRequest body) {
        final EditorialResponse editorial = facade.createEditorial(body);
        return new ResponseEntity<EditorialResponse>(editorial, HttpStatus.OK);
    }

    @PutMapping("/{idEditorial}")
    public ResponseEntity<EditorialResponse> editarEditorial(@PathVariable Integer idEditorial, @RequestBody EditorialRequest body) {
        final EditorialResponse editorial = facade.editEditorial(idEditorial, body);
        return new ResponseEntity<EditorialResponse>(editorial, HttpStatus.OK);
    }

    @DeleteMapping("/{idEditorial}")
    public ResponseEntity<EditorialResponse> eliminarEditorial(@PathVariable Integer idEditorial) {
        final EditorialResponse editorial = facade.deleteEditorial(idEditorial);
        return new ResponseEntity<EditorialResponse>(editorial, HttpStatus.OK);
    }

}
