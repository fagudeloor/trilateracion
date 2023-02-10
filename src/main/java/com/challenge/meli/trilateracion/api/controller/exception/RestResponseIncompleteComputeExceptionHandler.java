package com.challenge.meli.trilateracion.api.controller.exception;

import com.challenge.meli.trilateracion.api.Constants;
import com.challenge.meli.trilateracion.api.services.exception.IncompleteComputeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseIncompleteComputeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IncompleteComputeException.class})
    public ResponseEntity<Object> incompleteComputeExcception(Exception exception, WebRequest request){

        return new ResponseEntity<Object>(
                Constants.NO_SE_HA_LOGRADO_CALCULAR_LA_UBICACION, new HttpHeaders(), HttpStatus.NOT_FOUND
        );
    }

}
