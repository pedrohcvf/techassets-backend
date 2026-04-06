package com.techassets.techassets.patrimonio.colaborador.repository;

import com.techassets.techassets.patrimonio.colaborador.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
