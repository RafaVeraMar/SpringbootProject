package babel.rafavera.SpringbootProject.Mappers;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.web.dto.request.AutorRequest;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;
import org.springframework.stereotype.Component;

@Component
public class AutorMapperImpl implements AutorMapper {

    @Override
    public AutorResponse toDtoResponse(Autor autor) {
        return AutorResponse.builder().id(autor.getId()).nombre(autor.getNombre()).build();
    }

    @Override
    public Autor toEntity(AutorRequest autor) {
        final Autor entity = new Autor();
        entity.setNombre(autor.getNombre());
        return entity;
    }

}
