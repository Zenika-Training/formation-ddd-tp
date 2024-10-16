package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.ItemVO;
import com.zenika.ddd.mvc.dto.PlatDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlatMapper {
    public static List<ItemVO> toPlatVOList(List<PlatDto> plats) {
        List<ItemVO> itemVOList = new ArrayList<>();

        if (plats != null) {
            plats.forEach(platDto -> {
                ItemVO itemVO = ItemVO.builder().nom(platDto.getNom()).prix(platDto.getPrix()).images(platDto.getImages()).build();
                itemVOList.add(itemVO);
            });
        }

        return itemVOList;
    }
}
