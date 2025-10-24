package org.example.apimongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "formulario")
public class Formulario {
    @Id
    private String id;

    @Field("numero_cracha")
    private String numeroCracha;

    @Field("data_resposta")
    private LocalDateTime dataResposta;

    @Field("nivel_emissao")
    private Double nivelEmissao;

    @Field("classificacao_emissao")
    private String classificacaoEmissao;

    private List<RespostaItem> respostas;

    public Formulario() {}


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

    public String getClassificacaoEmissao() {
        return classificacaoEmissao;
    }

    public void setClassificacaoEmissao(String classificacaoEmissao) {
        this.classificacaoEmissao = classificacaoEmissao;
    }

    public List<RespostaItem> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaItem> respostas) {
        this.respostas = respostas;
    }
}