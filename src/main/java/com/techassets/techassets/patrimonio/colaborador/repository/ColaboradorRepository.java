package com.techassets.techassets.patrimonio.colaborador.repository;

import com.techassets.techassets.patrimonio.colaborador.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Long id(Long id);

    Long id(Long id);
}
