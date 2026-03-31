package com.techassets.techassets.estoque.controller;

import com.techassets.techassets.estoque.dto.ProdutoRequestDto;
import com.techassets.techassets.estoque.dto.ProdutoResponseDto;
import com.techassets.techassets.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    public ProdutoService produtoService;

    // CADASTRAR PRODUTO
    @PostMapping
    public ProdutoResponseDto addProduto(@RequestBody ProdutoRequestDto dto){
        return produtoService.addProduto(dto);
    }

    // LISTAR PRODUTOS
    @GetMapping
    public List<ProdutoResponseDto> listarProduto(){
        return produtoService.listarTodos();
    }

    // ATUALIZAR DADOS DO PRODUTO
    @PutMapping("/{id}")
    public ProdutoResponseDto updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDto dto){
        return produtoService.updateProduto(id, dto);
    }

    // LISTAR PRODUTO POR ID
    @GetMapping("/{id}")
    public ProdutoResponseDto listarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    // DELETAR PRODUTO
    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
    }


}
