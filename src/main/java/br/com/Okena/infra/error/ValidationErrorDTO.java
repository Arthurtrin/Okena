package br.com.Okena.infra.error;

import org.springframework.validation.FieldError;
import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorDTO(
        LocalDateTime timestamp,
        Integer status,
        List<Fields> fields) {

    public ValidationErrorDTO(List<FieldError> erros) {
        this(
                LocalDateTime.now(),
                400,
                erros.stream().map(Fields::new).toList()
        );
    }

    private record Fields(String campo, String mensagem){

        public Fields(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }
}
