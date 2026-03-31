package com.techassets.techassets.estoque.service;

import com.techassets.techassets.estoque.dto.ProdutoRequestDto;
import com.techassets.techassets.estoque.dto.ProdutoResponseDto;
import com.techassets.techassets.estoque.entity.Produto;
import com.techassets.techassets.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    // CADASTRAR PRODUTO
    public ProdutoResponseDto cadastrarProduto(ProdutoRequestDto dto){
        Produto produto = toEntity(dto);
        return toResponseDto(produtoRepository.save(produto));
    }

    // DELETAR PRODUTO
    public void deletarPorId(Long id){
        produtoRepository.deleteById(id);
    }

    // ATUALIZAR PRODUTO
    public ProdutoResponseDto atualizarProduto(Long id, ProdutoRequestDto dto){
        buscarEntidadePorId(id);
        Produto produto = toEntity(dto);
        produto.setId(id);
        return toResponseDto(produtoRepository.save(produto));
    }

    // BUSCAR TODOS OS PRODUTOS
    public List<ProdutoResponseDto> listarTodos(){
        return produtoRepository.findAll()
                                .stream()
                                .map(produto -> toResponseDto(produto))
                                .toList();
    }

    // BUSCAR POR ID
    public ProdutoResponseDto buscarPorId(Long id){
        return toResponseDto(buscarEntidadePorId(id));
    }

    // CONVERSÃO PARA ENTIDADE
    public Produto toEntity(ProdutoRequestDto dto){
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setCategoria(dto.categoria());
        produto.setUnidadeMedida(dto.unidadeMedida());
        produto.setQtdeMinima(dto.qtdeMinima());
        return produto;
    }

    // CONVERSÃO PARA DTO
    public ProdutoResponseDto toResponseDto(Produto produto){
        return new ProdutoResponseDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoria(),
                produto.getQtdeAtual(),
                produto.getQtdeMinima(),
                produto.getUnidadeMedida());
    }

    // METODO PARA AS BUSCAS
    private Produto buscarEntidadePorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto com id" + id + " não encontrado."));
    }

}