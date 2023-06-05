package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Editorial;

import java.util.List;

public interface EditorialService {

    /**
     *
     * @return List<Editorial>
     */
    List<Editorial> getEditoriales();

    /**
     *
     * @param id
     * @return Editorial
     */
    Editorial getEditorial(Integer id);

    /**
     *
     * @param editorial
     * @return Editorial
     */
    Editorial createEditorial(String editorial);

    /**
     *
     * @param id
     * @param editorial
     * @return Editorial
     */
    Editorial setEditorial(Integer id, String editorial);

    /**
     *
     * @param id
     * @return Editorial
     */
    Editorial deleteEditorial(Integer id);


}