package com.techassets.techassets.exception;

public class ColaboradorNotFoundException extends RuntimeException{

    public ColaboradorNotFoundException(Long id){
        super("Colaborador com ID: " + id + " não encontrado.");
    }

}
