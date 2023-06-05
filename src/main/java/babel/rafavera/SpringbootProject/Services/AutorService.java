package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Autor;

import java.util.List;

public interface AutorService {

    /**
     * Obtener todos los autores
     * @return List<Autor>
     */
    List<Autor> getAutores();

    /**
     * Obtener autor por id
     * @param id
     * @return Autor
     */
    Autor getAutor(Integer id);

    /**
     * Añadir un nuevo autor
     * @param autor
     * @return Autor
     */
    Autor createAutor(Autor autor);

    /**
     * Editar un autor
     * @param id
     * @param nombre
     * @return Autor
     */
    Autor editAutor(Integer id, String nombre);

    /**
     * Eliminar un autor
     * @param id
     * @return Autor
     */
    Autor deleteAutor(Integer id);

    /**
     * Obtener los autores de un documento determinado
     * @param idDocumento
     * @return List<Autor>
     */
    List<Autor> getAutoresByDocumento(Integer idDocumento);

}