package com.techassets.techassets.patrimonio.item.service;

import com.techassets.techassets.patrimonio.colaborador.entity.Colaborador;
import com.techassets.techassets.patrimonio.colaborador.repository.ColaboradorRepository;
import com.techassets.techassets.patrimonio.item.dto.ItemPatrimonioRequestDto;
import com.techassets.techassets.patrimonio.item.dto.ItemPatrimonioResponseDto;
import com.techassets.techassets.patrimonio.item.entity.ItemPatrimonio;
import com.techassets.techassets.patrimonio.item.enums.StatusItem;
import com.techassets.techassets.patrimonio.item.repository.ItemPatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPatrimonioService {

    @Autowired
    private ItemPatrimonioRepository itemPatrimonioRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // CONVERSÃO PARA DTO
    public ItemPatrimonioResponseDto toResponseDto(ItemPatrimonio itemPatrimonio){
        return new ItemPatrimonioResponseDto(
                itemPatrimonio.getId(),
                itemPatrimonio.getNome(),
                itemPatrimonio.getNumeroSerie(),
                itemPatrimonio.getCategoria(),
                itemPatrimonio.getColaborador() == null ? "Item sem colaborador" : itemPatrimonio.getColaborador().getNome(),
                itemPatrimonio.getStatusItem(),
                itemPatrimonio.getFornecedor());
    }

    // CONVERSÃO PARA ENTIDADE
    public ItemPatrimonio toEntity(ItemPatrimonioRequestDto dto){
        ItemPatrimonio itemPatrimonio = new ItemPatrimonio();
        Colaborador colaborador = colaboradorRepository.findById(dto.colaboradorId())
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado."));
        itemPatrimonio.setNome(dto.nome());
        itemPatrimonio.setNumeroSerie(dto.numeroSerie());
        itemPatrimonio.setCategoria(dto.categoria());
        itemPatrimonio.setColaborador(colaborador);
        itemPatrimonio.setStatusItem(dto.statusItem());
        itemPatrimonio.setFornecedor(dto.fornecedor());
        return itemPatrimonio;
    }

    // CADASTRAR ITEM
    public ItemPatrimonioResponseDto cadastrarItem(ItemPatrimonioRequestDto dto){
        ItemPatrimonio itemPatrimonio = toEntity(dto);
        return toResponseDto(itemPatrimonioRepository.save(itemPatrimonio));
    }

    // DELETAR ITEM
    public void deletarItem(Long id){
        itemPatrimonioRepository.deleteById(id);
    }

    // ATUALIZAR ITEM
    public ItemPatrimonioResponseDto atualizarItem(Long id, ItemPatrimonioRequestDto dto){
        ItemPatrimonio itemPatrimonio = buscarIdItem(id);
        atualizarItensCampos(itemPatrimonio, dto);
        return toResponseDto(itemPatrimonioRepository.save(itemPatrimonio));
    }

    // LISTAR TODAS
    public List<ItemPatrimonioResponseDto> listarTodos(){
        return itemPatrimonioRepository.findAll()
                .stream()
                .map(itemPatrimonio -> toResponseDto(itemPatrimonio))
                .toList();
    }

    // METODO PARA BUSCA DO ID
    private ItemPatrimonio buscarIdItem(Long id){
        return itemPatrimonioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O item com ID: " + id + " não foi encontrado"));
    }


    // LISTAR POR ID
    public ItemPatrimonioResponseDto listarPorId(Long id){
        return toResponseDto(buscarIdItem(id));
    }

    // LISTAR POR COLABORADOR
    public List<ItemPatrimonioResponseDto> listarPorColaborador(Long colaboradorId){
        return itemPatrimonioRepository.findByColaboradorId(colaboradorId)
                .stream()
                .map(itemPatrimonio -> toResponseDto(itemPatrimonio))
                .toList();
    }

    // LISTAR POR STATUS
    public List<ItemPatrimonioResponseDto> listarPorStatus(StatusItem status){
        return itemPatrimonioRepository.findByStatusItem(status)
                .stream()
                .map(itemPatrimonio -> toResponseDto(itemPatrimonio))
                .toList();
    }

    // ATUALIZAR OS CAMPOS
    public void atualizarItensCampos(ItemPatrimonio itemPatrimonio, ItemPatrimonioRequestDto dto){
        Colaborador colaborador = colaboradorRepository.findById(dto.colaboradorId())
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado."));
        itemPatrimonio.setNome(dto.nome());
        itemPatrimonio.setNumeroSerie(dto.numeroSerie());
        itemPatrimonio.setCategoria(dto.categoria());
        itemPatrimonio.setColaborador(colaborador);
        itemPatrimonio.setStatusItem(dto.statusItem());
        itemPatrimonio.setFornecedor(dto.fornecedor());
    }

}
