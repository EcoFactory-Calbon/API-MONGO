package org.example.apimongo.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.example.apimongo.dto.FormularioRequestDTO;
import org.example.apimongo.dto.FormularioResponseDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.openapi.FormularioOpenApi;
import org.example.apimongo.service.FormularioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulario")
public class FormularioController implements FormularioOpenApi {

    private final FormularioService formularioService;
    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FormularioResponseDTO>> listarFormularios() {
        List<FormularioResponseDTO> formularios = formularioService.listarFormularios();
        return ResponseEntity.ok(formularios);
    }

    @PostMapping("/inserir")
    public ResponseEntity<FormularioResponseDTO> criarFormulario(@Valid @RequestBody FormularioRequestDTO dto) {
        FormularioResponseDTO novoFormulario = formularioService.inserirFormulario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFormulario);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirFormulario(@PathVariable String id) {
        formularioService.excluirFormulario(id);
        return ResponseEntity.noContent().build();
    }
}
