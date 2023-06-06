package babel.rafavera.SpringbootProject.web.rest;

import babel.rafavera.SpringbootProject.Facades.AutorFacade;
import babel.rafavera.SpringbootProject.web.dto.request.AutorRequest;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/autores")
public class AutorController implements AutorControllerSwagger{

    private AutorFacade facade;

    @Autowired
    public AutorController(AutorFacade facade) {
        this.facade = facade;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AutorResponse>> obtenerAutores() {
        final List<AutorResponse> autores = facade.getAutores();
        final ResponseEntity<List<AutorResponse>> response = new ResponseEntity<>(autores, HttpStatus.OK);
        return response;
    }

    @Override
    @GetMapping("/{idAutor}")
    public ResponseEntity<AutorResponse> obtenerAutor(@PathVariable Integer idAutor) {
        final AutorResponse autor = facade.getAutor(idAutor);
        final ResponseEntity<AutorResponse> response = new ResponseEntity<>(autor, HttpStatus.OK);
        return response;
    }

    @Override
    @PutMapping("/{idAutor}")
    public ResponseEntity<AutorResponse> editarAutor(@PathVariable Integer idAutor, @RequestBody AutorRequest body) {
        final AutorResponse autor = facade.editAutor(idAutor, body);
        final ResponseEntity<AutorResponse> response = new ResponseEntity<>(autor, HttpStatus.OK);
        return response;
    }

    @Override
    @PostMapping
    public ResponseEntity<AutorResponse> crearAutor(@RequestBody AutorRequest body) {
        final AutorResponse autor = facade.crearAutor(body);
        final ResponseEntity<AutorResponse> response = new ResponseEntity<>(autor, HttpStatus.OK);
        return response;
    }

    @Override
    @DeleteMapping("/{idAutor}")
    public ResponseEntity<AutorResponse> eliminarAutor(@PathVariable Integer idAutor) {
        final AutorResponse autor = facade.eliminarAutor(idAutor);
        final ResponseEntity<AutorResponse> response = new ResponseEntity<>(autor, HttpStatus.OK);
        return response;
    }


}
