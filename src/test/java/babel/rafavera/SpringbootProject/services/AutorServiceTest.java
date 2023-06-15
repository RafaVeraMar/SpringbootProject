package babel.rafavera.SpringbootProject.services;

import babel.rafavera.SpringbootProject.Models.Autor;
import babel.rafavera.SpringbootProject.Respository.AutorRepository;
import babel.rafavera.SpringbootProject.Services.AutorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {
    @InjectMocks
    private AutorServiceImpl service;
    @Mock
    private AutorRepository repository;
    private Autor autor;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        autor = new Autor();
        autor.setId(1);
        autor.setNombre("Autor");
    }

    @Test
    public void getAutoresTest() {
        List<Autor> autorList = new ArrayList<>();
        autorList.add(autor);

        when(repository.findAll()).thenReturn(autorList);

        List<Autor> autores = service.getAutores();

        assertEquals(1,autores.size());
        assertEquals(autor, autores.get(0));
    }


    @Test
    public void getAutorTest() {
        when(repository.findById(1)).thenReturn(Optional.of(autor));

        Autor a = service.getAutor(1);
        assertEquals(1, a.getId());
        assertEquals("Autor", a.getNombre());
    }


    @Test
    public void getAutorTestNotFound() {
        when(repository.findById(2)).thenReturn(Optional.empty());
        Autor a = service.getAutor(2);
        assertNull(a.getId());
        assertNull(a.getNombre());
    }

    @Test
    public void createAutorTest(){
        when(repository.save(any())).thenReturn(autor);

        Autor a = service.createAutor(autor);
        assertEquals(1, a.getId());
        assertEquals("Autor", a.getNombre());
    }


    // TODO test de editAutor, Delete
    // TODO en editar y borrar añadir un test que comprueba que la id autor no exista o sea null



}