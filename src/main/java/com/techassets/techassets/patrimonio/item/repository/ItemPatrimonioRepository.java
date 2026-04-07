package com.techassets.techassets.patrimonio.item.repository;

import com.techassets.techassets.patrimonio.item.dto.ItemPatrimonioResponseDto;
import com.techassets.techassets.patrimonio.item.entity.ItemPatrimonio;
import com.techassets.techassets.patrimonio.item.enums.StatusItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPatrimonioRepository extends JpaRepository<ItemPatrimonio, Long> {

    List<ItemPatrimonio> findByColaboradorId(Long colaboradorId);

    List<ItemPatrimonio> findByStatusItem(StatusItem statusItem);

    Long id(long id);


}
