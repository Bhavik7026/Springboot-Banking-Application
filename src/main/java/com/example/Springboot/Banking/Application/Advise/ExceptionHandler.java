package com.example.Springboot.Banking.Application.Advise;

import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String , String> handler(MethodArgumentNotValidException ex){
        Map<String , String > errmess = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err->{
            errmess.put(((FieldError)err).getField(),err.getDefaultMessage());
        });
        return errmess;
    }


}
