package org.example.apimongo.controller;

import jakarta.validation.Valid;
import org.example.apimongo.dto.PerguntaRequestDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.service.PerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.apimongo.controller.PerguntaOpenApi;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController implements PerguntaOpenApi{

    private PerguntaService perguntaService;
    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }


    @GetMapping("/listar")
    public ResponseEntity<List<PerguntaResponseDTO>> listarPerguntas() {
        List<PerguntaResponseDTO> perguntas = perguntaService.listarPerguntas();
        return ResponseEntity.ok(perguntas);
    }

    @GetMapping("/buscarCategoria/{categoria}")
    public ResponseEntity<List<PerguntaResponseDTO>> buscarCategorias(@PathVariable String categoria) {
        return ResponseEntity.ok(perguntaService.buscarPorCategoria(categoria));
    }

    @PostMapping("/inserir")
    public ResponseEntity<PerguntaResponseDTO> adicionarPergunta(@RequestBody @Valid PerguntaRequestDTO dto) {
        PerguntaResponseDTO response = perguntaService.inserirPergunta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirPergunta(@PathVariable Integer id) {
            perguntaService.excluirPergunta(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PerguntaResponseDTO> atualizarPergunta(@PathVariable Integer id, @RequestBody @Valid PerguntaRequestDTO dto) {
        PerguntaResponseDTO response = perguntaService.atualizarPergunta(dto, id);
        return ResponseEntity.ok(response);
    }
}
