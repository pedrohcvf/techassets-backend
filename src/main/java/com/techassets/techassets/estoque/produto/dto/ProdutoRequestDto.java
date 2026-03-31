package com.techassets.techassets.estoque.produto.dto;

public record ProdutoRequestDto(String nome,
                                String descricao,
                                String categoria,
                                int qtdeMinima,
                                String unidadeMedida) {
}
