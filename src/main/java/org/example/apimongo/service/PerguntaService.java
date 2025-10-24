package org.example.apimongo.service;

import jakarta.validation.Valid;
import org.example.apimongo.dto.PerguntaRequestDTO;
import org.example.apimongo.dto.PerguntaResponseDTO;
import org.example.apimongo.exception.PerguntaNaoEncontradaException;
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
                pergunta.getId(),
                pergunta.getPergunta(),
                pergunta.getCategoria()
        );
    }

    public List<PerguntaResponseDTO> listarPerguntas() {
        return perguntaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<PerguntaResponseDTO> buscarPorCategoria(String categoria) {
        return perguntaRepository.findByCategoria(categoria)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PerguntaResponseDTO inserirPergunta(PerguntaRequestDTO dto) {
        Pergunta novaPergunta = new Pergunta();
        novaPergunta.setCategoria(dto.getCategoria());
        novaPergunta.setPergunta(dto.getPergunta());
        perguntaRepository.save(novaPergunta);
        return new PerguntaResponseDTO(novaPergunta.getCategoria(), novaPergunta.getPergunta());
    }


    public void excluirPergunta(Integer id) {
        Pergunta pergunta = perguntaRepository.findById(id)
                .orElseThrow(() -> new PerguntaNaoEncontradaException("Pergunta com id: "+ id +" não encontrado"));
        perguntaRepository.delete(pergunta);
    }


    public PerguntaResponseDTO atualizarPergunta(@Valid PerguntaRequestDTO perguntaAtualizado, Integer id) {
        Pergunta existente = perguntaRepository.findById(id)
                .orElseThrow(() -> new PerguntaNaoEncontradaException("Pergunta com o Id " + id + " não encontrada"));
        existente.setPergunta(perguntaAtualizado.getPergunta());
        existente.setCategoria(perguntaAtualizado.getCategoria());
        Pergunta atualizado = perguntaRepository.save(existente);
        return toResponseDTO(atualizado);

    }
}
