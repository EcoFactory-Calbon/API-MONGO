package org.example.apimongo.controller;

import org.example.apimongo.dto.FormularioResponseDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.service.FormularioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/formulario")
public class FormularioController {

    private final FormularioService formularioService;
    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FormularioResponseDTO>> listarFormularios() {
        List<FormularioResponseDTO> formularios = formularioService.getFormularios();
        return ResponseEntity.ok(formularios);
    }}
