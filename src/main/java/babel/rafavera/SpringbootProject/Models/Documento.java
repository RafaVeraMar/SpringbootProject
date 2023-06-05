package babel.rafavera.SpringbootProject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String subtitulo;
    private String idioma;
    private String tipo;
    private String ruta;
    private String descripcion;
    private String palabrasClave;

    private Integer idEditorial;

}
