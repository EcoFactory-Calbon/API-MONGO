package org.example.apimongo.service;

import org.example.apimongo.dto.FormularioRequestDTO;
import org.example.apimongo.dto.FormularioResponseDTO;
import org.example.apimongo.dto.RespostaItemDTO;
import org.example.apimongo.exception.FormularioNaoEncontradoException;
import org.example.apimongo.exception.PerguntaNaoEncontradaException;
import org.example.apimongo.model.Formulario;
import org.example.apimongo.model.Pergunta;
import org.example.apimongo.model.RespostaItem;
import org.example.apimongo.repository.FormularioRepository;
import org.example.apimongo.repository.PerguntaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FormularioService {

    private final FormularioRepository formularioRepository;
    private final PerguntaRepository perguntaRepository;
    private final CalculoCarbonoService calculoCarbonoService;

    public FormularioService(FormularioRepository formularioRepository, PerguntaRepository perguntaRepository, CalculoCarbonoService calculoCarbonoService) {
        this.formularioRepository = formularioRepository;
        this.perguntaRepository = perguntaRepository;
        this.calculoCarbonoService = calculoCarbonoService;
    }

    private Formulario fromRequestDTO(FormularioRequestDTO dto) {
        Formulario formulario = new Formulario();
        formulario.setNumeroCracha(dto.getNumeroCracha());

        List<RespostaItem> respostas = dto.getRespostas()
                .stream()
                .map(respostaDTO -> {
            RespostaItem item = new RespostaItem();
            item.setIdPergunta(respostaDTO.getIdPergunta());
            item.setResposta(respostaDTO.getResposta());
            return item;
        }).collect(Collectors.toList());

        formulario.setRespostas(respostas);
        return formulario;
    }

    public FormularioResponseDTO toResponseDTO(Formulario formulario) {
        FormularioResponseDTO dto = new FormularioResponseDTO();
        dto.setId(formulario.getId());
        dto.setNumeroCracha(formulario.getNumeroCracha());
        dto.setDataResposta(formulario.getDataResposta());
        dto.setNivelEmissao(formulario.getNivelEmissao());

        List<RespostaItemDTO> respostasDTO = formulario.getRespostas().stream().map(item -> {
            RespostaItemDTO itemDTO = new RespostaItemDTO();
            itemDTO.setIdPergunta(item.getIdPergunta());
            itemDTO.setResposta(item.getResposta());
            return itemDTO;
        }).collect(Collectors.toList());

        dto.setRespostas(respostasDTO);
        return dto;
    }
    public List<FormularioResponseDTO> listarFormularios() {
        return formularioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public FormularioResponseDTO inserirFormulario(FormularioRequestDTO requestDTO) {
        Formulario formulario = fromRequestDTO(requestDTO);
        formulario.setDataResposta(LocalDateTime.now());
        double nivelEmissaoCalculado = calculoCarbonoService.calcular(requestDTO.getRespostas());
        formulario.setNivelEmissao(nivelEmissaoCalculado);
        Formulario savedFormulario = formularioRepository.save(formulario);
        return toResponseDTO(savedFormulario);
    }

    public void excluirFormulario(String id) {
        Formulario formulario = formularioRepository.findById(id)
                .orElseThrow(() -> new FormularioNaoEncontradoException("Formulario com id: "+ id +" não encontrado"));
        formularioRepository.delete(formulario);
    }

}