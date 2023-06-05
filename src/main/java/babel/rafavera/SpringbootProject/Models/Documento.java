package babel.rafavera.SpringbootProject.Models;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name="id_editorial", insertable = true, updatable = true)
    private Editorial editorial;

}
