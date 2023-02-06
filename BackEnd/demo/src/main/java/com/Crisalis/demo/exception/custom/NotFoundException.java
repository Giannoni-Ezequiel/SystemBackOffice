package com.Crisalis.demo.exception.custom;

public class NotFoundException extends RuntimeException{

    private static final String Description = "Elemento no encontrado (404)";

    public NotFoundException(String error){
        super(Description + ". " + error);
    }
}
