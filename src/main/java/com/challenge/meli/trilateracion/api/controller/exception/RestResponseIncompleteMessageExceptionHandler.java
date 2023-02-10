package com.challenge.meli.trilateracion.api.controller.exception;


import com.challenge.meli.trilateracion.api.Constants;
import com.challenge.meli.trilateracion.api.services.exception.IncompleteMessageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Maneja los errores del aplicativo
 */
@ControllerAdvice
public class RestResponseIncompleteMessageExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IncompleteMessageException.class})
    public ResponseEntity<Object> incompleteMessageException(Exception exception, WebRequest request){

        return new ResponseEntity<Object>(
                Constants.NO_SE_HA_LOGRADO_DECIFRAR_EL_MENSAJE, new HttpHeaders(), HttpStatus.NOT_FOUND
        );
    }
}
