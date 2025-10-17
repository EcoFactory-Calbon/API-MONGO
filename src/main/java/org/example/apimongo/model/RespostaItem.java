package org.example.apimongo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class RespostaItem {

    @Field("id_pergunta") // Garante que o mapeamento do campo "id_pergunta" seja feito corretamente
    private Integer idPergunta;

    private Integer resposta;

    public RespostaItem() {}

    // Getters e Setters...
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