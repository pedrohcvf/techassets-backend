package com.techassets.techassets.patrimonio.colaborador.controller;

import com.techassets.techassets.patrimonio.colaborador.dto.ColaboradorRequestDto;
import com.techassets.techassets.patrimonio.colaborador.dto.ColaboradorResponseDto;
import com.techassets.techassets.patrimonio.colaborador.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    // CADASTRAR COLABORADOR
    @PostMapping
    public ColaboradorResponseDto cadastrarColaborador(@Valid @RequestBody ColaboradorRequestDto dto){
        return colaboradorService.cadastrarColaborador(dto);
    }

    // LISTAR TODOS OS COLABORADORES
    @GetMapping
    public List<ColaboradorResponseDto> listarTodos(){
        return colaboradorService.listarTodos();
    }

    // ATUALIZAR COLABORADOR
    @PutMapping("/{id}")
    public ColaboradorResponseDto atualizarColaborador(@PathVariable Long id, @Valid @RequestBody ColaboradorRequestDto dto){
        return colaboradorService.atualizarColaborador(id, dto);
    }

    // LISTAR COLABORADOR POR ID
    @GetMapping("/{id}")
    public ColaboradorResponseDto listarPorId(@PathVariable Long id){
        return colaboradorService.listarPorId(id);
    }

    // DELETAR COLABORADOR
    @DeleteMapping("/{id}")
    public void deletarColaborador(@PathVariable Long id){
        colaboradorService.deletarColaborador(id);
    }

}
