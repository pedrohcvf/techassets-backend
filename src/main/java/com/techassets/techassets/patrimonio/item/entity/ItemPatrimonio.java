package com.techassets.techassets.patrimonio.item.entity;

import com.techassets.techassets.patrimonio.colaborador.entity.Colaborador;
import com.techassets.techassets.patrimonio.item.enums.StatusItem;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_itemPatrimonio")
public class ItemPatrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String numeroSerie;

    private String categoria;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Colaborador colaborador;

    @Enumerated(EnumType.STRING)
    private StatusItem statusItem;

    private String fornecedor;

}
