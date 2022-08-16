package com.lucasantos.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);//repassando a chamada para runtimeException passando a mensagem;
    }
}