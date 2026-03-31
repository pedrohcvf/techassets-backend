package com.techassets.techassets.estoque.movimentacao.entity;

import com.techassets.techassets.estoque.movimentacao.enums.TipoMovimentacao;
import com.techassets.techassets.estoque.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    private int quantidade;

    private LocalDateTime data;

    private String observacao;

}
