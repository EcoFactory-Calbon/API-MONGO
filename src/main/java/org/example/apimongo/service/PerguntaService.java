package org.example.apimongo.service;

import org.example.apimongo.dto.PerguntaRequestDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.model.Pergunta;
import org.example.apimongo.repository.PerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerguntaService {
    private PerguntaRepository perguntaRepository;
    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public Pergunta fromRequestDTO(PerguntaRequestDTO dto) {
        Pergunta pergunta = new Pergunta();
        pergunta.setPergunta(dto.getPergunta());
        pergunta.setCategoria(dto.getCategoria());
        return pergunta;
    }

    public PerguntaResponseDTO toResponseDTO(Pergunta pergunta) {
        return new PerguntaResponseDTO(
                pergunta.getPergunta(),
                pergunta.getCategoria()
        );
    }

    public List<PerguntaResponseDTO> getPerguntas() {
        return perguntaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
