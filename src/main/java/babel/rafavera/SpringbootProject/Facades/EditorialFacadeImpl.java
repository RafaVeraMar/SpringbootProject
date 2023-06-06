package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.Services.EditorialService;
import babel.rafavera.SpringbootProject.web.dto.request.EditorialRequest;
import babel.rafavera.SpringbootProject.web.dto.response.EditorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditorialFacadeImpl implements EditorialFacade {

    private EditorialService service;
    private EditorialMapper mapper;

    @Autowired
    public EditorialFacadeImpl(EditorialService service, EditorialMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public List<EditorialResponse> getEditoriales() {
        final List<Editorial> editoriales = service.getEditoriales();
        return editoriales.stream().map(e -> mapper.toDtoResponse(e)).toList();
    }

    @Override
    public EditorialResponse getEditorial(Integer id) {
        final Editorial editorial = service.getEditorial(id);
        return mapper.toDtoResponse(editorial);
    }

    @Override
    public EditorialResponse createEditorial(EditorialRequest editorial) {
        final Editorial e = service.createEditorial(editorial.getNombre());
        return mapper.toDtoResponse(e);
    }

    @Override
    public EditorialResponse editEditorial(Integer id, EditorialRequest editorial) {
        final Editorial e = service.setEditorial(id, editorial.getNombre());
        return mapper.toDtoResponse(e);
    }

    @Override
    public EditorialResponse deleteEditorial(Integer id) {
        final Editorial editorial = service.deleteEditorial(id);
        return mapper.toDtoResponse(editorial);
    }

}
