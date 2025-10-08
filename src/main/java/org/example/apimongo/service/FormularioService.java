package org.example.apimongo.service;

import org.example.apimongo.repository.FormularioRepository;
import org.springframework.stereotype.Service;

@Service
public class FormularioService {

    private final FormularioRepository formularioRepository;
    public FormularioService(FormularioRepository formularioRepository) {
        this.formularioRepository = formularioRepository;
    }


}
