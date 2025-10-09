package org.example.apimongo.service;

import org.example.apimongo.dto.FormularioRequestDTO;
import org.example.apimongo.dto.FormularioResponseDTO;
import org.example.apimongo.dto.PerguntaRequestDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.model.Formulario;
import org.example.apimongo.model.Pergunta;
import org.example.apimongo.repository.FormularioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormularioService {

    private final FormularioRepository formularioRepository;
    public FormularioService(FormularioRepository formularioRepository) {
        this.formularioRepository = formularioRepository;
    }

    public Formulario fromRequestDTO(FormularioRequestDTO dto) {
        Formulario formulario = new Formulario();
        formulario.setResposta(dto.getResposta());
        formulario.setNivelEmissao(dto.getNivelEmissao());
        formulario.setIdPergunta(dto.getIdPergunta());
        return formulario;
    }

    public FormularioResponseDTO toResponseDTO(Formulario formulario) {
        return new FormularioResponseDTO(
                formulario.getId(),
                formulario.getResposta(),
                formulario.getNivelEmissao(),
                formulario.getIdPergunta()

        );
    }


    public List<FormularioResponseDTO> getFormularios() {
        return formularioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


}
