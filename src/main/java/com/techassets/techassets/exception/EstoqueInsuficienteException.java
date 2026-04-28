package com.techassets.techassets.exception;

public class EstoqueInsuficienteException extends RuntimeException {

    public EstoqueInsuficienteException() {
        super("A quantidade no estoque é insuficiente.");
    }

}