package com.techassets.techassets.patrimonio.item.dto;

import com.techassets.techassets.patrimonio.item.enums.StatusItem;

public record ItemPatrimonioResponseDto(Long id,
                                        String nome,
                                        String numeroSerie,
                                        String categoria,
                                        String nomeColaborador,
                                        StatusItem statusItem,
                                        String fornecedor) {
}
