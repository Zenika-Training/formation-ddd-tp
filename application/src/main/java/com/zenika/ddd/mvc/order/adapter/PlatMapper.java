package com.zenika.ddd.mvc.order.adapter;

import com.zenika.ddd.subdomaindelivery.order.Item;
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
                            .nom(platDto.getNom())
                            .prix(platDto.getPrix())
                            .images(platDto.getImages())
                            .build();
            itemList.add(item);
        });

        return itemList;
    }
}
