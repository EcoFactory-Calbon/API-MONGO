package org.example.apimongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorGlobal {

    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<String> manipulaDadosInvalidos(DadosInvalidosException ex)    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Dados inválidos: " + ex.getMessage());
    }


    @ExceptionHandler(PerguntaNaoEncontradaException.class)
    public ResponseEntity<String> manipuladorPerguntaNaoEncontradaException(PerguntaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pergunta não encontrada "+ex.getMessage());
    }

    @ExceptionHandler(FormularioNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorFormularioNaoEncontradoException(FormularioNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Formulario não encontrado "+ex.getMessage());
    }
}
