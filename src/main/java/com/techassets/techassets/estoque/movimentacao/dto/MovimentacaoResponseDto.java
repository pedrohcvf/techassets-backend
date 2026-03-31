package com.techassets.techassets.estoque.movimentacao.dto;

import com.techassets.techassets.estoque.movimentacao.enums.TipoMovimentacao;
import java.time.LocalDateTime;

public record MovimentacaoResponseDto(Long produtoId,
                                      String nomeProduto,
                                      TipoMovimentacao tipo,
                                      int quantidade,
                                      LocalDateTime data,
                                      String observacao) {
}
