package com.viniciuselias.projetotcc.model.entities.exceptions;

public class inputDataException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public inputDataException(String msg) {
        super("Input erro: "+ msg);
    }
}
