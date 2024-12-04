package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.order.ItemVO;
import com.zenika.ddd.mvc.dto.PlatDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlatMapper {
    public static List<ItemVO> toPlatVOList(List<PlatDto> plats) {
        List<ItemVO> itemVOList = new ArrayList<>();

        plats.forEach(platDto -> {
            ItemVO itemVO = new ItemVO(platDto.getNom(), platDto.getPrix());
            itemVOList.add(itemVO);
        });

        return itemVOList;
    }
}
