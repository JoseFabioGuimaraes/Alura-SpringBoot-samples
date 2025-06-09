package med.voll.api.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarError404(EntityNotFoundException ex){
        var error = new ErrorResponse(
                404,
                "Recurso não encontrado",
                ex.getMessage()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarError400(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(listaErrors::new).toList());
    }

    public record listaErrors(String campo, String mensagem){
        public listaErrors (FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
    public record ErrorResponse(int status, String error, String message){}
}
