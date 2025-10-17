package org.example.apimongo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO que representa uma única resposta a uma pergunta do formulário.")
public class RespostaItemDTO {

    @NotNull(message = "O ID da pergunta não pode ser nulo.")
    @Schema(description = "ID da pergunta que está sendo respondida.",
            example = "101")
    private Integer idPergunta;

    @NotNull(message = "A resposta não pode ser nula.")
    @Min(value = 0, message = "O valor da resposta deve ser no mínimo 0.")
    @Max(value = 5, message = "O valor da resposta deve ser no máximo 5.")
    @Schema(description = "Valor numérico da resposta selecionada, geralmente um índice ou peso (de 0 a 5).",
            example = "3")
    private Integer resposta;


    // Getters e Setters
    public Integer getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Integer getResposta() {
        return resposta;
    }

    public void setResposta(Integer resposta) {
        this.resposta = resposta;
    }
}