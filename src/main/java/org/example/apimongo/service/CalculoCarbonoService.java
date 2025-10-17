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
            // 1. Busca a pergunta no banco para obter a categoria
            Integer idPergunta = respostaItem.getIdPergunta();
            Pergunta pergunta = perguntaRepository.findById(idPergunta)
                    .orElseThrow(() -> new NoSuchElementException("Pergunta com ID " + idPergunta + " não encontrada."));

            // 2. Obtém a pontuação baseada no valor da resposta (0-5)
            double pontuacaoBase = getPontuacaoPorResposta(respostaItem.getResposta());

            // 3. Obtém o peso/multiplicador baseado na categoria da pergunta
            double pesoCategoria = getPesoPorCategoria(pergunta.getCategoria());

            // 4. Calcula a emissão da resposta e soma ao total
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
            case "transporte": return 1.5;
            case "alimentação": return 1.2;
            case "consumo": return 1.0;
            case "energia": return 1.1;
            case "conhecimento": return 0.5;
            // Adicione outras categorias aqui...
            default: return 1.0; // Peso padrão para categorias não listadas
        }
    }
}