package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Services.AutorService;
import babel.rafavera.SpringbootProject.web.dto.request.AutorRequest;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorFacadeImpl implements AutorFacade {

    private AutorService autorService;
    private AutorMapper autorMapper;

    @Autowired
    public AutorFacadeImpl(AutorService autorService, AutorMapper autorMapper) {
        this.autorService = autorService;
        this.autorMapper = autorMapper;
    }

    @Override
    public List<AutorResponse> getAutores() {
        final List<Autor> autores = autorService.getAutores();
        return autores.stream().map(autor -> autorMapper.toDtoResponse(autor)).toList();
    }

    @Override
    public AutorResponse getAutor(Integer id) {
        final Autor autor = autorService.getAutor(id);
        return autorMapper.toDtoResponse(autor);
    }

    @Override
    public AutorResponse editAutor(Integer id, AutorRequest autorRequest) {
        final Autor autor = autorService.editAutor(id, autorRequest.getNombre());
        return autorMapper.toDtoResponse(autor);
    }

    @Override
    public AutorResponse crearAutor(AutorRequest autorRequest) {
        final Autor autor = autorService.createAutor(autorMapper.toEntity(autorRequest));
        return autorMapper.toDtoResponse(autor);
    }

    @Override
    public AutorResponse eliminarAutor(Integer id) {
        final Autor autor = autorService.deleteAutor(id);
        return autorMapper.toDtoResponse(autor);
    }

}
