package com.techassets.techassets.patrimonio.item.dto;

import com.techassets.techassets.patrimonio.item.enums.StatusItem;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ItemPatrimonioRequestDto(@NotBlank String nome,
                                       @NotBlank String numeroSerie,
                                       @NotBlank String categoria,
                                       @Min(0) Long colaboradorId,
                                       StatusItem statusItem,
                                       @NotBlank String fornecedor) {
}
