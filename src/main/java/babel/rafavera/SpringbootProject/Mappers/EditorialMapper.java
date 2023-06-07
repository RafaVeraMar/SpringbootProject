package babel.rafavera.SpringbootProject.Mappers;

import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.web.dto.response.EditorialResponse;

public interface EditorialMapper {

    EditorialResponse toDtoResponse(Editorial editorial);
}
