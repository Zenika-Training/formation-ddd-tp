package com.zenika.ddd.order;

import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.doc.Stub;

@Stub
public class DeliveryManStub implements DeliveryManRepository {

    @Override
    public DeliveryManEntity getDeliveryMan() {
        return DeliveryManEntity.builder().build();
    }
}
