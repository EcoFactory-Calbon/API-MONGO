package org.example.apimongo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "DTO para submeter as respostas de um formulário.")
public class FormularioRequestDTO {

    @NotNull(message = "Número do crachá não pode ser nulo")
    @Schema(description = "Identificador do crachá do usuário que respondeu.", example = "12345-6")
    private String numeroCracha;

    @NotEmpty(message = "A lista de respostas não pode estar vazia")
    @Schema(description = "Lista contendo os IDs da pergunta e da alternativa escolhida.")
    private List<RespostaItemDTO> respostas;

    // Getters e Setters
    public String getNumeroCracha() {
        return numeroCracha;
    }

    public void setNumeroCracha(String numeroCracha) {
        this.numeroCracha = numeroCracha;
    }

    public List<RespostaItemDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaItemDTO> respostas) {
        this.respostas = respostas;
    }
}