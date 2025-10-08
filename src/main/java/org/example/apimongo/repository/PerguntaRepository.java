package org.example.apimongo.repository;

import org.example.apimongo.model.Pergunta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerguntaRepository extends MongoRepository<Pergunta, Integer> {
}
