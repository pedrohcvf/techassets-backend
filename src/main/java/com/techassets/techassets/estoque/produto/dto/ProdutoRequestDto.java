package com.techassets.techassets.estoque.produto.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProdutoRequestDto(@NotBlank String nome,
                                String descricao,
                                @NotBlank String categoria,
                                @Min(0) int qtdeMinima,
                                @NotBlank String unidadeMedida) {
}
