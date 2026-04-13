package com.techassets.techassets.patrimonio.colaborador.dto;

import jakarta.validation.constraints.NotBlank;

public record ColaboradorRequestDto(@NotBlank String nome,
                                    @NotBlank String email,
                                    @NotBlank String departamento,
                                    @NotBlank String cargo,
                                    boolean ativo) {
}
