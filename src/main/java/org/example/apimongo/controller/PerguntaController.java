package org.example.apimongo.controller;

import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.service.PerguntaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

    private PerguntaService perguntaService;
    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }


    @GetMapping("/listar")
    public ResponseEntity<List<PerguntaResponseDTO>> listarPerguntas() {
        List<PerguntaResponseDTO> perguntas = perguntaService.getPerguntas();
        return ResponseEntity.ok(perguntas);
    }


}
