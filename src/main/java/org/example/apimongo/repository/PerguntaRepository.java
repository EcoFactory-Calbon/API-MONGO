package org.example.apimongo.repository;

import org.example.apimongo.model.Pergunta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PerguntaRepository extends MongoRepository<Pergunta, Integer> {

    List<Pergunta> findByCategoria(String categoria);
}
