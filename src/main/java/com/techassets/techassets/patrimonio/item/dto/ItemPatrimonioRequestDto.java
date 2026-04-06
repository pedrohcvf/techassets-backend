package com.techassets.techassets.patrimonio.item.dto;

import com.techassets.techassets.patrimonio.item.enums.StatusItem;

public record ItemPatrimonioRequestDto(String nome,
                                       String numeroSerie,
                                       String categoria,
                                       Long colaboradorId,
                                       StatusItem statusItem,
                                       String fornecedor) {
}
