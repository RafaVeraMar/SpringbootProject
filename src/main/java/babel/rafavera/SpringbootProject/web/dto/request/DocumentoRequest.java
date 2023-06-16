package babel.rafavera.SpringbootProject.web.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DocumentoRequest {

    private String titulo;
    private String subtitulo;
    private String idioma;
    private String tipo;
    private String ruta;
    private String descripcion;
    private String palabrasClave;
    private Integer editorial;
    private List<Integer> autores;

}
