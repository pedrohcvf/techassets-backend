package com.techassets.techassets.estoque.movimentacao.controller;

import com.techassets.techassets.estoque.movimentacao.dto.MovimentacaoRequestDto;
import com.techassets.techassets.estoque.movimentacao.dto.MovimentacaoResponseDto;
import com.techassets.techassets.estoque.movimentacao.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    // REGISTRO DE MOVIMENTAÇÃO
    @PostMapping
    public MovimentacaoResponseDto registrarMovimentacao(@Valid @RequestBody MovimentacaoRequestDto dto){
        return movimentacaoService.registrarMovimentacao(dto);
    }

    // LISTAR TODAS
    @GetMapping
    public List<MovimentacaoResponseDto> listarMovimentacoes(){
        return movimentacaoService.listarTodas();
    }

    // LISTAR POR PRODUTO
    @GetMapping("/{produtoId}/produto")
    public List<MovimentacaoResponseDto> listarPorProduto(@PathVariable Long produtoId){
        return movimentacaoService.listarPorProduto(produtoId);
    }

}
