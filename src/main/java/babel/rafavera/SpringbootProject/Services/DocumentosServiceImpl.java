package babel.rafavera.SpringbootProject.Services;

import babel.rafavera.SpringbootProject.Models.Documento;
import babel.rafavera.SpringbootProject.Respository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentosServiceImpl implements DocumentosService {


    private DocumentoRepository repository;
    @Autowired
    public DocumentosServiceImpl(DocumentoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Documento> getDocumentos() {
        return repository.findAll();
    }

    @Override
    public Documento getDocumento(Integer id) {

        return repository.findById(id).orElse(new Documento());
        // an Exception should be thrown here in case of not finding any Document
        // here is defined that, if a document is not found then returns an empty document
        // when I'm sure that i will get the document then: return repository.findById(id).get())
    }

    @Override
    public Documento createDocumento(Documento documento) {

        return repository.save(documento);
        // this would be done by the controller or FACADE

    }

    /**
     *
     * @param id
     * @param doc
     * @return
     * The first If checks the obtained Document id is null. This check is neccessary because of the logic defined into
     * the method getDocumento.
     */
    @Override
    public Documento editDocumento(Integer id, Documento doc) {

        Documento documento = getDocumento(id);
        if (documento.getId()!=null){
            if (doc.getSubtitulo()!=null) {
                documento.setSubtitulo(doc.getIdioma());
            }
            if (doc.getIdioma()!=null) {
                documento.setIdioma(doc.getIdioma());
            }
            if (doc.getTipo()!=null) {
                documento.setTipo(doc.getTipo());
                }
            if (doc.getRuta()!=null) {
                documento.setRuta(doc.getRuta());
            }
            if (doc.getDescripcion()!=null) {
                documento.setDescripcion(doc.getDescripcion());
            }
            if (doc.getPalabrasClave()!=null) {
                documento.setPalabrasClave(doc.getPalabrasClave());
            }
            if (doc.getEditorial()!=null) {
                documento.setEditorial(doc.getEditorial());
            }
            documento = repository.save(documento);

        }
        return documento;

    }


    @Override
    public Documento deleteDocumento(Integer id) {

        final Documento documento = getDocumento(id);
        if (documento.getId()!=null) {
            repository.deleteById(id);
        }
        return documento;
    }
}
