package com.techassets.techassets.estoque.produto.repository;

import com.techassets.techassets.estoque.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
