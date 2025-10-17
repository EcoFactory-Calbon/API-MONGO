package org.example.apimongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "formulario")
public class Formulario {
    @Id
    private String id; // _id do MongoDB é uma String

    @Field("numero_cracha")
    private String numeroCracha;

    @Field("data_resposta")
    private LocalDateTime dataResposta;

    @Field("nivel_emissao")
    private Double nivelEmissao;

    private List<RespostaItem> respostas; // Lista de objetos aninhados

    public Formulario() {}

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCracha() {
        return numeroCracha;
    }

    public void setNumeroCracha(String numeroCracha) {
        this.numeroCracha = numeroCracha;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Double getNivelEmissao() {
        return nivelEmissao;
    }

    public void setNivelEmissao(Double nivelEmissao) {
        this.nivelEmissao = nivelEmissao;
    }

    public List<RespostaItem> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaItem> respostas) {
        this.respostas = respostas;
    }
}