package com.techassets.techassets.patrimonio.colaborador.dto;

public record ColaboradorRequestDto( String nome,
                                     String email,
                                     String departamento,
                                     String cargo,
                                     boolean ativo) {
}
