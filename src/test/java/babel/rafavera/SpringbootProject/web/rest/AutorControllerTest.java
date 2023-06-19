package babel.rafavera.SpringbootProject.web.rest;

import babel.rafavera.SpringbootProject.Facades.AutorFacade;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.web.servlet.function.ServerResponse.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AutorControllerTest {

    @MockBean
    private AutorFacade facade;
    @Autowired
    private MockMvc mvc;

    @Test
    public void obtenerAutoresTest() throws Exception {
        List<AutorResponse> list = new ArrayList<>();
        list.add(AutorResponse.builder().id(1).nombre("Autor").build());
        when(facade.getAutores()).thenReturn(list);

        mvc.perform(MockMvcRequestBuilders.get("/biblioteca/autores"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"nombre\":\"Autor\"}]"));
    }

@Test
    public void crearAutorTest() throws Exception {
        when(facade.crearAutor(any())).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());

        mvc.perform((MockMvcRequestBuilders.post("/biblioteca/autores").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"nombre\":\"Autor\"}")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"nombre\":\"Autor\"}"));
}

@Test
    public void editarAutorTest() throws Exception {
        when(facade.editAutor(any(),any())).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());

        mvc.perform(put("/biblioteca/autores/1").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"nombre\":\"Autor\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"nombre\":\"Autor\"}"));
}

@Test
    public void eliminarAutorTest() throws Exception {
        when(facade.eliminarAutor(1)).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());

        mvc.perform(delete("/biblioteca/autores/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"nombre\":\"Autor\"}"));

    }

}
// TODO completar los test del resto de controladores
