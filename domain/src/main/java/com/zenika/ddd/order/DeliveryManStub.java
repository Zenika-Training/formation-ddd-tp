package com.zenika.ddd.order;

import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.order.model.DeliveryManEntity;
import com.zenika.ddd.port.DeliveryManRepository;

import java.util.UUID;

@Stub
public class DeliveryManStub implements DeliveryManRepository {

    @Override
    public DeliveryManEntity getDeliveryMan() {
        return DeliveryManEntity.builder()
                .id(UUID.fromString("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b"))
                .nom("nom")
                .prenom("prenom")
                .build();
    }
}
