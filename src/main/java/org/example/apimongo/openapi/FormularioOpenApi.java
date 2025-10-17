package org.example.apimongo.openapi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apimongo.dto.FormularioRequestDTO;
import org.example.apimongo.dto.FormularioResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Formulários", description = "Endpoints para submissão e gerenciamento de formulários respondidos")
@RequestMapping("/formulario")
public interface FormularioOpenApi {

    @Operation(summary = "Listar todos os formulários", description = "Retorna uma lista com todos os formulários que foram respondidos.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioResponseDTO.class)))
    })
    @GetMapping("/listar")
    ResponseEntity<List<FormularioResponseDTO>> listarFormularios();

    @Operation(summary = "Submeter um novo formulário", description = "Cria um novo registro de formulário respondido no banco de dados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Formulário criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida (dados do corpo inválidos)", content = @Content)
    })
    @PostMapping("/inserir")
    ResponseEntity<FormularioResponseDTO> criarFormulario(@RequestBody @Valid FormularioRequestDTO dto);

    @Operation(summary = "Excluir um formulário", description = "Exclui um formulário existente pelo seu ID (String do MongoDB).")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Formulário excluído com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Formulário não encontrado", content = @Content)
    })
    @DeleteMapping("/excluir/{id}")
    ResponseEntity<Void> excluirFormulario(
            @Parameter(description = "ID do formulário a ser excluído", required = true, example = "63ca72a6e7e4e83782ea3a2f")
            @PathVariable String id);
}