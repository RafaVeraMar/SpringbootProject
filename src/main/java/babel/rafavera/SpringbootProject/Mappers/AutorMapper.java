package babel.rafavera.SpringbootProject.Mappers;


import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.web.dto.request.AutorRequest;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;

public interface AutorMapper {

    AutorResponse toDtoResponse(Autor autor);

    Autor toEntity(AutorRequest autor);

}
