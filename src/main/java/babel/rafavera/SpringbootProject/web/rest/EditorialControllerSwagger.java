package babel.rafavera.SpringbootProject.web.rest;


import babel.rafavera.SpringbootProject.web.dto.request.EditorialRequest;
import babel.rafavera.SpringbootProject.web.dto.response.EditorialResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name="Documentos", description= "Administración para la entidad Editorial")
public interface EditorialControllerSwagger {

    @Operation(summary = "Obtener el listado de Editoriales", operationId = "getEditoriales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EditorialResponse.class))})
    })
    ResponseEntity<List<EditorialResponse>> obtenerEditoriales();


    @Operation(summary = "Obtener una Editorial por su Id", operationId = "getEditorial")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EditorialResponse.class))})
    })
    ResponseEntity<EditorialResponse> obtenerEditorial(Integer idEditorial);


    @Operation(summary = "Crear una Editorial", operationId = "postEditoriales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EditorialResponse.class))})
    })
    ResponseEntity<EditorialResponse> crearEditorial(EditorialRequest body);


    @Operation(summary = "Editar una Editorial", operationId = "patchEditoriales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EditorialResponse.class))})
    })
    ResponseEntity<EditorialResponse> editarEditorial(Integer idEditorial, EditorialRequest body);


    @Operation(summary = "Eliminar una Editorial",operationId = "DeleteEditoral")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = EditorialResponse.class))})
    })
    ResponseEntity<EditorialResponse>eliminarEditorial (Integer idEditorial);
}