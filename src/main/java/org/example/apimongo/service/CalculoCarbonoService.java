package org.example.apimongo.service;

import org.example.apimongo.dto.RespostaItemDTO;
import org.example.apimongo.model.Pergunta;
import org.example.apimongo.repository.PerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CalculoCarbonoService {

    private final PerguntaRepository perguntaRepository;

    public CalculoCarbonoService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }


    public double calcular(List<RespostaItemDTO> respostas) {
        double emissaoTotal = 0.0;

        for (RespostaItemDTO respostaItem : respostas) {
            Integer idPergunta = respostaItem.getIdPergunta();
            Pergunta pergunta = perguntaRepository.findById(idPergunta)
                    .orElseThrow(() -> new NoSuchElementException("Pergunta com ID " + idPergunta + " não encontrada."));

            double pontuacaoBase = getPontuacaoPorResposta(respostaItem.getResposta());

            double pesoCategoria = getPesoPorCategoria(pergunta.getCategoria());

            emissaoTotal += pontuacaoBase * pesoCategoria;
        }

        return emissaoTotal;
    }

    private double getPontuacaoPorResposta(int resposta) {
        switch (resposta) {
            case 0: return 0;
            case 1: return 100;
            case 2: return 300;
            case 3: return 600;
            case 4: return 1000;
            case 5: return 1500;
            default: return 0;
        }
    }

    private double getPesoPorCategoria(String categoria) {
        switch (categoria.toLowerCase()) {
            case "transporte": return 1.2;
            case "alimentação": return 0.9;
            case "consumo": return 0.7;
            case "energia": return 0.8;
            case "conhecimento": return 0.2;
            default: return 1.0;
        }
    }

    public String classificarEmissao(Double nivelEmissao) {
        if (nivelEmissao <= 3.9) {
            return "Baixa";
        } else if (nivelEmissao <= 8.9) {
            return "Média";
        } else {
            return "Alta";
        }
    }
}