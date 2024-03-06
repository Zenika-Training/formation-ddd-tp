package com.zenika.ddd.infrastructure.adapter;

import com.zenika.ddd.aggregateorder.EnumStatusItem;
import com.zenika.ddd.aggregateorder.Item;
import com.zenika.ddd.infrastructure.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemMapper {

    public Item map(ItemEntity itemEntity) {
        return Item.builder()
                   .id(new Item.ItemVoId(UUID.fromString(itemEntity.getId())))
                   .name(itemEntity.getName())
                   .status(EnumStatusItem.valueOf(itemEntity.getStatus().name()))
                   .price(itemEntity.getPrice())
                   .build();
    }
}
