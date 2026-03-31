package com.techassets.techassets.estoque.movimentacao.service;

import com.techassets.techassets.estoque.movimentacao.dto.MovimentacaoRequestDto;
import com.techassets.techassets.estoque.movimentacao.dto.MovimentacaoResponseDto;
import com.techassets.techassets.estoque.movimentacao.entity.Movimentacao;
import com.techassets.techassets.estoque.movimentacao.enums.TipoMovimentacao;
import com.techassets.techassets.estoque.movimentacao.repository.MovimentacaoRepository;
import com.techassets.techassets.estoque.produto.entity.Produto;
import com.techassets.techassets.estoque.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    public MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public ProdutoRepository produtoRepository;

    // CONVERSÃO PARA DTO
    public MovimentacaoResponseDto toResponseDto(Movimentacao movimentacao){
        return new MovimentacaoResponseDto(
                movimentacao.getProduto().getId(),
                movimentacao.getProduto().getNome(),
                movimentacao.getTipo(),
                movimentacao.getQuantidade(),
                movimentacao.getData(),
                movimentacao.getObservacao()
        );
    }

    // REGISTRO DE MOVIMENTAÇÃO
    public MovimentacaoResponseDto registerMovimentacao(MovimentacaoRequestDto dto){

        // BUSCA NO DB
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // VERIFICAÇÃO DO TIPO DE MOVIMENTAÇÃO
        if (dto.tipo() == TipoMovimentacao.ENTRADA){
            produto.setQtdeAtual(produto.getQtdeAtual() + dto.quantidade());
        } else {
            produto.setQtdeAtual(produto.getQtdeAtual() - dto.quantidade());
        }

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setProduto(produto);
        movimentacao.setTipo(dto.tipo());
        movimentacao.setQuantidade(dto.quantidade());
        movimentacao.setData(LocalDateTime.now());

        produtoRepository.save(produto);

        return toResponseDto(movimentacaoRepository.save(movimentacao));
    }
}
