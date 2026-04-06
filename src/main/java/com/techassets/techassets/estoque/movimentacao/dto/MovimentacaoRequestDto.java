package com.techassets.techassets.estoque.movimentacao.dto;

import com.techassets.techassets.estoque.movimentacao.enums.TipoMovimentacao;

public record MovimentacaoRequestDto(Long produtoId,
                                     TipoMovimentacao tipo,
                                     int quantidade) {
}
