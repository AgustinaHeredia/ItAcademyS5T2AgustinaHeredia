package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<ErrorObject> handlePlayerNotFoundException(PlayerNotFoundException ex, WebRequest request) {
        ErrorObject errorObject = createErrorObject(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorObject> handleReviewNotFoundException(ReviewNotFoundException ex, WebRequest request) {
        ErrorObject errorObject = createErrorObject(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGenericException(Exception ex, WebRequest request) {
        // Se puedes definir una respuesta de error genérica para cualquier otra excepción no especificada
        ErrorObject errorObject = createErrorObject(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorObject createErrorObject(HttpStatus status, String message) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(status.value());
        errorObject.setMessage(message);
        errorObject.setTimestamp(new Date());
        return errorObject;
    }
}
