package br.com.Okena.infra;

import br.com.Okena.infra.exceptions.BairroNotFoundException;
import br.com.Okena.infra.exceptions.ReportNotFoundException;
import br.com.Okena.infra.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity ReportNaoEncontrada(ReportNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(
                        e.getMessage(),
                        404,
                        LocalDateTime.now()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity ReportNaoEncontrada(UserNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(
                        e.getMessage(),
                        404,
                        LocalDateTime.now()));
    }

    @ExceptionHandler(BairroNotFoundException.class)
    public ResponseEntity ReportNaoEncontrada(BairroNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(
                        e.getMessage(),
                        404,
                        LocalDateTime.now()));
    }




}
