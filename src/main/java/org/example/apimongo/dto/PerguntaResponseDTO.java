package org.example.apimongo.dto;

public class PerguntaResponseDTO {

    private String pergunta;

    private String categoria;

    public PerguntaResponseDTO() {}
    public PerguntaResponseDTO(String pergunta, String categoria) {
        this.pergunta = pergunta;
        this.categoria = categoria;
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
