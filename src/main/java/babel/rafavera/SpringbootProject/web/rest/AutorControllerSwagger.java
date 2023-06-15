package babel.rafavera.SpringbootProject.web.rest;

import babel.rafavera.SpringbootProject.web.dto.request.AutorRequest;
import babel.rafavera.SpringbootProject.web.dto.response.AutorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "1. Autores", description = "Administracion para la entidad Autor")
public interface AutorControllerSwagger {

    @Operation(summary = "Obtener listado de Autores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutorResponse.class))})
    })
    ResponseEntity<List<AutorResponse>> obtenerAutores();

    @Operation(summary = "Obtener Autor por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutorResponse.class))})
    })
    ResponseEntity<AutorResponse> obtenerAutor(Integer idAutor);

    @Operation(summary = "Editar un Autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutorResponse.class))})
    })
    ResponseEntity<AutorResponse> editarAutor(Integer idAutor, AutorRequest body);

    @Operation(summary = "Crear un nuevo Autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutorResponse.class))})
    })
    ResponseEntity<AutorResponse> crearAutor(AutorRequest body);

    @Operation(summary = "Borrar Autor por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AutorResponse.class))})
    })
    ResponseEntity<AutorResponse> eliminarAutor(Integer idAutor);

}
