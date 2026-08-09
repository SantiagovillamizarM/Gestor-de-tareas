package com.gestor.dominio.excepciones;

public class TareaNoEncontradaException extends RuntimeException {
    public TareaNoEncontradaException (String message){
    super(message);
    }
}
