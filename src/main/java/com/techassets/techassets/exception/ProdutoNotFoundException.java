package com.techassets.techassets.exception;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException(Long id){
        super("Produto com ID: " + id + " não foi encontrado.");
    }

}
