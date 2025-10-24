package org.example.apimongo.repository;

import org.example.apimongo.model.Formulario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormularioRepository extends MongoRepository<Formulario, String> {

    List<Formulario> findByNumeroCracha(String numeroCracha);
}