package org.example.apimongo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "DTO para representar os dados de um formulário respondido.")
public class FormularioResponseDTO {

    @Schema(description = "ID único do formulário no formato MongoDB.", example = "63ca72a6e7e4e83782ea3a2f")
    private String id;

    @Schema(description = "Número do crachá do usuário que respondeu.", example = "12345-6")
    private String numeroCracha;

    @Schema(description = "Data e hora em que o formulário foi submetido.", example = "2025-10-17T08:30:00")
    private LocalDateTime dataResposta;

    @Schema(description = "Pontuação calculada ou nível de emissão com base nas respostas.", example = "4.7")
    private Double nivelEmissao;

    @Schema(description = "Classificação do nível de emissão.", example = "Média")
    private String classificacaoEmissao;

    @Schema(description = "Lista das respostas fornecidas pelo usuário.")
    private List<RespostaItemDTO> respostas;

    public FormularioResponseDTO() {}

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

    public List<RespostaItemDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaItemDTO> respostas) {
        this.respostas = respostas;
    }
}