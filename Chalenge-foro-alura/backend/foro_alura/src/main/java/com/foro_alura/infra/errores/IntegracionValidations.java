package com.foro_alura.infra.errores;

public class IntegracionValidations extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public IntegracionValidations(String s){
        super(s);
    }
}


