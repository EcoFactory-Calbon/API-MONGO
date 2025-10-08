package org.example.apimongo.repository;

import org.example.apimongo.model.Formulario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormularioRepository extends MongoRepository<Formulario, Integer>{

}

