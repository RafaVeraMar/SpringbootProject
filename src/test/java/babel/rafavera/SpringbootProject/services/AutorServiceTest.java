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


import static java.nio.file.Files.delete;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


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

    @Test
    public void editAutorTest() {

        when(repository.findById(1)).thenReturn(Optional.of(autor));
        when(repository.save(any(Autor.class))).thenReturn(autor);


        Autor result = service.editAutor(1, "Rafa");


        assertEquals(1, result.getId());
        assertEquals("Rafa", result.getNombre());
    }

    @Test
    public void editAutorNotFoundTest() {
        when(repository.findById(2)).thenReturn(Optional.empty());

        Autor result = service.editAutor(2, "Rafa");

        assertNull(result.getId());
        assertNull(result.getNombre());

        verify(repository, never()).save(any(Autor.class));
    }

    @Test
    public void deleteAutorTest(){
        when(repository.findById(1)).thenReturn(Optional.of(autor));
        Autor result = service.deleteAutor(1);

        assertEquals(autor, result); //

        verify(repository, times(1)).delete(autor);
    }

    @Test
    public void deleteAutorNotFoundTest() {
        when(repository.findById(2)).thenReturn(Optional.empty());
        Autor result = service.deleteAutor(2);

        assertNotEquals(autor,result); //

        verify(repository,never()).delete(autor);
    }

//TODO test para getAutoresByDocumento

}