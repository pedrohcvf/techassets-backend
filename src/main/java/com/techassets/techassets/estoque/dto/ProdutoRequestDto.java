package com.techassets.techassets.estoque.dto;

public record ProdutoRequestDto(String nome,
                                String descricao,
                                String categoria,
                                int qtdeMinima,
                                String unidadeMedida) {
}
