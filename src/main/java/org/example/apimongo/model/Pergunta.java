package org.example.apimongo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "perguntas")
public class Pergunta {
    @Id
    private Integer id;
    private String pergunta;
    private String categoria;

    public Pergunta() {}
    public Pergunta(String pergunta, String categoria) {
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
