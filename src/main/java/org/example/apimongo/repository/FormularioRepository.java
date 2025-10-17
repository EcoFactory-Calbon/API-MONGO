package org.example.apimongo.repository;

import org.example.apimongo.model.Formulario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends MongoRepository<Formulario, String> {
}