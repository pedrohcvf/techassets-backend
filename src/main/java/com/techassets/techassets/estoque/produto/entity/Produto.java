package com.techassets.techassets.estoque.produto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private String categoria;

    @Column(nullable = false)
    private int qtdeAtual;

    @Column(nullable = false)
    private int qtdeMinima;

    private String unidadeMedida;
}