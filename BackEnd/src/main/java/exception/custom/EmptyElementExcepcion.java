package com.Administracion.Crisalis.exception.custom;

public class EmptyElementExcepcion extends RuntimeException{

    private static final String DESCRIPTION = "Empty element (400)";

    public EmptyElementExcepcion(String detail){
        super(DESCRIPTION + ". " + detail);
    }
    private String description = "elemento vacio: ";

}
