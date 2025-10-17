package org.example.apimongo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.apimongo.model.Pergunta;

@Schema(description = "DTO para representar os dados de uma pergunta retornada pela API.")
public class PerguntaResponseDTO {

    @Schema(description = "Identificador único da pergunta.",
            example = "1")
    private Integer id;

    @Schema(description = "O texto da pergunta.",
            example = "Quantos litros de água são economizados ao reciclar 1kg de papel?")
    private String pergunta;

    @Schema(description = "A categoria da pergunta.",
            example = "Reciclagem")
    private String categoria;

    public PerguntaResponseDTO() {}

    public PerguntaResponseDTO(Integer id,String pergunta, String categoria) {
        this.id = id;
        this.pergunta = pergunta;
        this.categoria = categoria;
    }

    public PerguntaResponseDTO(String pergunta, String categoria) {
        this.pergunta = pergunta;
        this.categoria = categoria;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}