package com.techassets.techassets.patrimonio.colaborador.service;

import com.techassets.techassets.patrimonio.colaborador.dto.ColaboradorRequestDto;
import com.techassets.techassets.patrimonio.colaborador.dto.ColaboradorResponseDto;
import com.techassets.techassets.patrimonio.colaborador.entity.Colaborador;
import com.techassets.techassets.patrimonio.colaborador.repository.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository){
        this.colaboradorRepository = colaboradorRepository;
    }

    // CONVERSÃO PARA DTO
    public ColaboradorResponseDto toResponseDto(Colaborador colaborador){
        return new ColaboradorResponseDto(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getEmail(),
                colaborador.getDepartamento(),
                colaborador.getCargo(),
                colaborador.isAtivo());
    }

    // CONVERSÃO PARA ENTIDADE
    public Colaborador toEntity(ColaboradorRequestDto dto){
        Colaborador colaborador = new Colaborador();
        colaborador.setNome(dto.nome());
        colaborador.setEmail(dto.email());
        colaborador.setDepartamento(dto.departamento());
        colaborador.setCargo(dto.cargo());
        colaborador.setAtivo(dto.ativo());
        return colaborador;
    }

    // CADASTRAR COLABORADOR
    public ColaboradorResponseDto cadastrarColaborador(ColaboradorRequestDto dto){
        Colaborador colaborador = toEntity(dto);
        return toResponseDto(colaboradorRepository.save(colaborador));
    }

    // DELETAR COLABORADOR
    public void deletarColaborador(Long id){
        colaboradorRepository.deleteById(id);
    }

    // ATUALIZAR COLABORADOR
    public ColaboradorResponseDto atualizarColaborador(Long id, ColaboradorRequestDto dto){
        Colaborador colaborador = buscarEntidadePorId(id);
        atualizarColaboradorCampos(colaborador, dto);
        return toResponseDto(colaboradorRepository.save(colaborador));
    }

    // LISTAR TODOS
    public List<ColaboradorResponseDto> listarTodos(){
        return colaboradorRepository.findAll()
                .stream()
                .map(colaborador -> toResponseDto(colaborador))
                .toList();
    }

    // METODO PARA BUSCA DO ID
    public Colaborador buscarEntidadePorId(Long id){
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador com id" + id + " não encontrado"));
    }

    // LISTAR POR ID
    public ColaboradorResponseDto listarPorId(Long id){
        return toResponseDto(buscarEntidadePorId(id));
    }

    // ATUALIZAR CAMPOS
    public void atualizarColaboradorCampos(Colaborador colaborador, ColaboradorRequestDto dto){
        colaborador.setNome(dto.nome());
        colaborador.setEmail(dto.email());
        colaborador.setDepartamento(dto.departamento());
        colaborador.setCargo(dto.cargo());
        colaborador.setAtivo(dto.ativo());
    }

}

