package babel.rafavera.SpringbootProject.Mappers;

import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.web.dto.response.EditorialResponse;
import org.springframework.stereotype.Component;

@Component
public class EditorialMapperImpl implements EditorialMapper {

    @Override
    public EditorialResponse toDtoResponse(Editorial editorial) {
        return EditorialResponse.builder().id(editorial.getId()).nombre(editorial.getNombre()).build();
    }

}
