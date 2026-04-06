package com.techassets.techassets.patrimonio.colaborador.dto;

public record ColaboradorResponseDto(Long id,
                                     String nome,
                                     String email,
                                     String departamento,
                                     String cargo,
                                     boolean ativo) {
}
