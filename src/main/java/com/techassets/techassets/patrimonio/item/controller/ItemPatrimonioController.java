package com.techassets.techassets.patrimonio.item.controller;

import com.techassets.techassets.patrimonio.item.dto.ItemPatrimonioRequestDto;
import com.techassets.techassets.patrimonio.item.dto.ItemPatrimonioResponseDto;
import com.techassets.techassets.patrimonio.item.enums.StatusItem;
import com.techassets.techassets.patrimonio.item.service.ItemPatrimonioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemPatrimonioController {

    @Autowired
    private ItemPatrimonioService itemPatrimonioService;

    // CADASTRAR ITEM
    @PostMapping
    public ItemPatrimonioResponseDto cadastrarItem(@Valid @RequestBody ItemPatrimonioRequestDto dto){
        return itemPatrimonioService.cadastrarItem(dto);
    }

    // LISTAR TODOS
    @GetMapping
    public List<ItemPatrimonioResponseDto> listarTodos(){
        return itemPatrimonioService.listarTodos();
    }

    // LISTAR POR ID
    @GetMapping("/{id}")
    public ItemPatrimonioResponseDto listarPorId(@PathVariable Long id){
        return itemPatrimonioService.listarPorId(id);
    }

    // ATUALIZAR ITEM
    @PutMapping("/{id}")
    public ItemPatrimonioResponseDto atualizarItem(@Valid @RequestBody ItemPatrimonioRequestDto dto, @PathVariable Long id){
        return itemPatrimonioService.atualizarItem(id,dto);
    }

    // DELETAR ITEM
    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Long id){
        itemPatrimonioService.deletarItem(id);
    }

    // LISTAR POR COLABORADOR
    @GetMapping("/{colaboradorId}/colaborador")
    public List<ItemPatrimonioResponseDto> listarPorColaborador(@PathVariable Long colaboradorId){
        return itemPatrimonioService.listarPorColaborador(colaboradorId);
    }

    // LISTAR POR STATUS
    @GetMapping("/{status}/status")
    public List<ItemPatrimonioResponseDto> listarPorStatus(@PathVariable StatusItem status){
        return itemPatrimonioService.listarPorStatus(status);
    }

}
