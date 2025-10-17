package org.example.apimongo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para criar ou atualizar uma pergunta.")
public class PerguntaRequestDTO {

    @NotBlank(message = "O texto da pergunta não pode ser vazio.")
    @Schema(description = "O texto da pergunta em si.",
            example = "Qual tipo de combustivel você utiliza?")
    private String pergunta;

    @NotBlank(message = "A categoria não pode ser vazia.")
    @Schema(description = "A categoria a qual a pergunta pertence.",
            example = "Trasporte")
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}