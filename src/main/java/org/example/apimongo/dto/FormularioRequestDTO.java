package org.example.apimongo.dto;

import jakarta.validation.constraints.NotNull;

public class FormularioRequestDTO {

    @NotNull(message = "resposta não pode ser nula, responda de 0 a 5")
    private Integer resposta;

    private String nivelEmissao;

    private Integer idPergunta;

    public String getNivelEmissao() {
        return nivelEmissao;
    }

    public void setNivelEmissao(String nivelEmissao) {
        this.nivelEmissao = nivelEmissao;
    }

    public Integer getResposta() {
        return resposta;
    }

    public void setResposta(Integer resposta) {
        this.resposta = resposta;
    }

    public Integer getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }
}
