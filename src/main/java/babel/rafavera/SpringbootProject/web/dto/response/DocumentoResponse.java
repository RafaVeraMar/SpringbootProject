package babel.rafavera.SpringbootProject.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DocumentoResponse {

    private Integer id;
    private String titulo;
    private String subtitulo;
    private String idioma;
    private String tipo;
    private String ruta;
    private String descripcion;
    private String palabrasClave;
    private String editorial;
    private List<String> autores;


/*
// In case of Lombok not available, the constructors & Setter & Getter should be generated


    public DocumentoResponse() {
    }


    public DocumentoResponse(String titulo, String subtitulo, String idioma, String tipo, String ruta, String descripcion, String palabrasClave, String editorial, List<String> autores) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.idioma = idioma;
        this.tipo = tipo;
        this.ruta = ruta;
        this.descripcion = descripcion;
        this.palabrasClave = palabrasClave;
        this.editorial = editorial;
        this.autores = autores;
    }

    */


/*
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

*/

}
