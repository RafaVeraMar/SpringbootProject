package babel.rafavera.SpringbootProject.Facades;

import babel.rafavera.SpringbootProject.web.dto.request.EditorialRequest;
import babel.rafavera.SpringbootProject.web.dto.response.EditorialResponse;

import java.util.List;

public interface EditorialFacade {

    /**
     *
     * @return
     */
    List<EditorialResponse> getEditoriales();

    /**
     *
     * @param id
     * @return
     */
    EditorialResponse getEditorial(Integer id);

    /**
     *
     * @param editorial
     * @return
     */
    EditorialResponse createEditorial(EditorialRequest editorial);

    /**
     *
     * @param id
     * @param editorial
     * @return
     */
    EditorialResponse editEditorial(Integer id, EditorialRequest editorial);

    /**
     *
     * @param id
     * @return
     */
    EditorialResponse deleteEditorial(Integer id);
}
