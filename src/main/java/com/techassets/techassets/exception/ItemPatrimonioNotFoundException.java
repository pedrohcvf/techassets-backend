package com.techassets.techassets.exception;

public class ItemPatrimonioNotFoundException extends RuntimeException {

    public ItemPatrimonioNotFoundException(Long id) {
        super("Item com ID: " + id + " não foi encontrado.");
    }

}
