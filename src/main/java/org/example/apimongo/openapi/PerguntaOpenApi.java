package org.example.apimongo.controller; // ou org.example.apimongo.controller.api

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apimongo.dto.PerguntaRequestDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Perguntas", description = "Endpoints para gerenciamento de perguntas do quiz")
@RequestMapping("/pergunta") // O mapeamento base também pode ficar na interface
public interface PerguntaOpenApi {

    @Operation(summary = "Listar todas as perguntas", description = "Retorna uma lista com todas as perguntas cadastradas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerguntaResponseDTO.class)))
    })
    @GetMapping("/listar")
    ResponseEntity<List<PerguntaResponseDTO>> listarPerguntas();


    @Operation(summary = "Adicionar uma nova pergunta", description = "Cria uma nova pergunta no banco de dados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Pergunta criada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerguntaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida (dados do corpo inválidos)", content = @Content)
    })
    @PostMapping("/inserir")
    ResponseEntity<PerguntaResponseDTO> adicionarPergunta(@RequestBody @Valid PerguntaRequestDTO dto);


    @Operation(summary = "Excluir uma pergunta", description = "Exclui uma pergunta existente pelo seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pergunta excluída com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pergunta não encontrada", content = @Content)
    })
    @DeleteMapping("/excluir/{id}")
    ResponseEntity<Void> excluirPergunta(
            @Parameter(description = "ID da pergunta a ser excluída", required = true, example = "1")
            @PathVariable Integer id);


    @Operation(summary = "Atualizar uma pergunta", description = "Atualiza os dados de uma pergunta existente com base no seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pergunta atualizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerguntaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida (dados do corpo inválidos)", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pergunta não encontrada", content = @Content)
    })
    @PutMapping("/atualizar/{id}")
    ResponseEntity<PerguntaResponseDTO> atualizarPergunta(
            @Parameter(description = "ID da pergunta a ser atualizada", required = true, example = "1")
            @PathVariable Integer id,
            @RequestBody @Valid PerguntaRequestDTO dto);
}