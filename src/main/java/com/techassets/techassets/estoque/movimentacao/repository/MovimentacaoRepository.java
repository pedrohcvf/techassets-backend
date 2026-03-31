package com.techassets.techassets.estoque.movimentacao.repository;

import com.techassets.techassets.estoque.movimentacao.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
