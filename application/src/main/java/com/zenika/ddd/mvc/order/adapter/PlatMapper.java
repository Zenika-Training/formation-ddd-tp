package com.zenika.ddd.mvc.order.adapter;

import com.zenika.ddd.aggregateorder.Item;
import com.zenika.ddd.mvc.order.dto.PlatDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlatMapper {

    public static List<Item> toPlatVOList(List<PlatDto> plats) {
        List<Item> itemList = new ArrayList<>();

        plats.forEach(platDto -> {
            Item item = Item.builder()
                            .name(platDto.getNom())
                            .price(platDto.getPrix())
                            .build();
            itemList.add(item);
        });

        return itemList;
    }
}
