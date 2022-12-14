package com.Crisalis.demo.exception.custom;

public class NotCreatedException extends RuntimeException{
    private static final String DESCRIPTION = "Error in created (400)";

    public NotCreatedException(String detail){
        super(DESCRIPTION + ". " + detail);
    }
}

