package com.techassets.techassets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleRunTimeException(RuntimeException exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(500, exception.getMessage(), LocalDateTime.now(), List.of());
        return ResponseEntity.internalServerError().body(errorResponseDto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> produtoNotFound(ProdutoNotFoundException exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(404, exception.getMessage(), LocalDateTime.now(), List.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> colaboradorNotFound(ColaboradorNotFoundException exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(404, exception.getMessage(), LocalDateTime.now(), List.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> itemPatrimonioNotFound(ItemPatrimonioNotFoundException exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(404, exception.getMessage(), LocalDateTime.now(), List.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> estoqueInsuficiente(EstoqueInsuficienteException exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(422, exception.getMessage(), LocalDateTime.now(), List.of());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponseDto);
    }
}
