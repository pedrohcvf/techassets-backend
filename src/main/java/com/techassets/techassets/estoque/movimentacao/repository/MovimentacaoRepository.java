package com.techassets.techassets.estoque.movimentacao.repository;

import com.techassets.techassets.estoque.movimentacao.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findByProdutoId(Long produtoId);

}
