package org.example.apimongo.dto;

public class FormularioResponseDTO {

    private Integer id;
    private Integer resposta;
    private String nivelEmissao;
    private Integer idPergunta;

    public FormularioResponseDTO() {}

    public FormularioResponseDTO(Integer id,Integer resposta, String nivelEmissao, Integer idPergunta) {
        this.id = id;
        this.resposta = resposta;
        this.nivelEmissao = nivelEmissao;
        this.idPergunta = idPergunta;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
