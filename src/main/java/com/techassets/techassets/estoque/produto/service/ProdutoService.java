package com.techassets.techassets.estoque.produto.service;

import com.techassets.techassets.estoque.produto.dto.ProdutoRequestDto;
import com.techassets.techassets.estoque.produto.dto.ProdutoResponseDto;
import com.techassets.techassets.estoque.produto.entity.Produto;
import com.techassets.techassets.estoque.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    // CADASTRAR PRODUTO
    public ProdutoResponseDto addProduto(ProdutoRequestDto dto){
        Produto produto = toEntity(dto);
        return toResponseDto(produtoRepository.save(produto));
    }

    // DELETAR PRODUTO
    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }

    // ATUALIZAR PRODUTO
    public ProdutoResponseDto updateProduto(Long id, ProdutoRequestDto dto){
        Produto produto = buscarEntidadePorId(id);
        atualizarProdutoCampos(produto, dto);
        return toResponseDto(produtoRepository.save(produto));
    }

    // LISTAR TODOS OS PRODUTOS
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

    // ATUALIZAR CAMPOS
    public void atualizarProdutoCampos(Produto produto, ProdutoRequestDto dto){
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setCategoria(dto.categoria());
        produto.setUnidadeMedida(dto.unidadeMedida());
        produto.setQtdeMinima(dto.qtdeMinima());
    }

}