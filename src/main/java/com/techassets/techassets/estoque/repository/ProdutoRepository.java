package com.techassets.techassets.estoque.repository;

import com.techassets.techassets.estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
