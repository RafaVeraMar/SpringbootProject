package babel.rafavera.SpringbootProject.web.rest;


import babel.rafavera.SpringbootProject.web.dto.request.DocumentoRequest;
import babel.rafavera.SpringbootProject.web.dto.response.DocumentoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name="Documentos", description= "Administración para la entidad Documentos")
public interface DocumentosControllerSwagger {


    @Operation(summary = "Obtener el listado de Documentos", operationId = "getDocumentos")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200",
                    content= {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = DocumentoResponse.class))})
    })
    ResponseEntity<List<DocumentoResponse>> obtenerDocumentos();


    @Operation(summary = "Obtener un Documento por su id", operationId = "getDocumentoById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = DocumentoResponse.class))})
    })
    ResponseEntity<DocumentoResponse> obtenerDocumento(Integer idDocumento);


    @Operation(summary = "Crear un Documento", operationId = "postCrearDocumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema= @Schema(implementation = DocumentoResponse.class))})
    })
ResponseEntity<DocumentoResponse> crearDocumento(DocumentoRequest body);

    @Operation(summary = "Editar campos de un Documento", operationId = "patchEditarDocumento")

    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = DocumentoResponse.class))})
    })
ResponseEntity<DocumentoResponse> editarDocumento(Integer idDocumento, DocumentoRequest body);


    @Operation(summary = "Eliminar un documento por su Id", operationId = "deleteEliminarDocumento")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = DocumentoResponse.class))})
    })
ResponseEntity<DocumentoResponse> eliminarDocumento(Integer idDocumento);


}

