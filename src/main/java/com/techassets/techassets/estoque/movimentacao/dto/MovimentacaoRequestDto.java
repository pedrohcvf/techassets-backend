package com.techassets.techassets.estoque.movimentacao.dto;

import com.techassets.techassets.estoque.movimentacao.enums.TipoMovimentacao;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MovimentacaoRequestDto(@Min(0) @NotNull Long produtoId,
                                     @NotNull TipoMovimentacao tipo,
                                     @Min(0) int quantidade,
                                     String observacao) {
}
