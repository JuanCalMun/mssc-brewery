package guru.springframework.msscbrewery.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BreweryExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> validationHandler(MethodArgumentNotValidException exception) {
        List<String> errorList = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getObjectName() + ": " + e.getField() + " -> " + e.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
