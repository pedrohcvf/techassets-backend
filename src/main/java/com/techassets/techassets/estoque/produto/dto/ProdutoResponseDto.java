package com.techassets.techassets.estoque.produto.dto;

public record ProdutoResponseDto(Long id,
                                 String nome,
                                 String descricao,
                                 String categoria,
                                 int qtdeAtual,
                                 int qtdeMinima,
                                 String unidadeMedida) {
}
