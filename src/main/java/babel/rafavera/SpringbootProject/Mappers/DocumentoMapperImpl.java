package babel.rafavera.SpringbootProject.Mappers;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Models.Documento;
import babel.rafavera.SpringbootProject.Models.Editorial;
import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentoMapperImpl implements DocumentoMapper {

    @Override
    public DocumentoResponse toDtoResp(Documento doc, List<Autor> autores) {
        final List<String> autoresStr = new ArrayList<>();
        autores.forEach(autor -> autoresStr.add(autor.getNombre()));
        return DocumentoResponse.builder()
                .id(doc.getId())
                .titulo(doc.getTitulo())
                .subtitulo(doc.getSubtitulo())
                .idioma(doc.getIdioma())
                .tipo(doc.getTipo())
                .ruta(doc.getRuta())
                .descripcion(doc.getDescripcion())
                .palabrasClave(doc.getPalabrasClave())
                .editorial(doc.getEditorial().getNombre())
                .autores(autoresStr)
                .build();
    }

    @Override
    public Documento toEntity(DocumentoResponse doc) {
        final Documento documento = new Documento();
        documento.setId(doc.getId());
        documento.setTitulo(doc.getTitulo());
        documento.setSubtitulo(doc.getSubtitulo());
        documento.setIdioma(doc.getIdioma());
        documento.setTipo(doc.getTipo());
        documento.setRuta(doc.getRuta());
        documento.setDescripcion(doc.getDescripcion());
        documento.setPalabrasClave(doc.getPalabrasClave());
        return documento;
    }

    @Override
    public Documento toEntity(DocumentoRequest doc, Editorial editorial) {
        final Documento documento = new Documento();
        documento.setTitulo(doc.getTitulo());
        documento.setSubtitulo(doc.getSubtitulo());
        documento.setIdioma(doc.getIdioma());
        documento.setTipo(doc.getTipo());
        documento.setRuta(doc.getRuta());
        documento.setDescripcion(doc.getDescripcion());
        documento.setPalabrasClave(doc.getPalabrasClave());
        documento.setEditorial(editorial);
        return documento;
    }

}
