package babel.rafavera.SpringbootProject.Mappers;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Models.Documento;
import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;

import java.util.List;

public interface DocumentoMapper {

    DocumentoResponse toDtoResp(Documento doc, List<Autor> autores);

    Documento toEntity(DocumentoResponse resp);

    Documento toEntity(DocumentoRequest req, Editorial editorial);
}
