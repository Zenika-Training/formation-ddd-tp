package com.zenika.ddd.aggregateorder;

import com.zenika.ddd.doc.DomainObject;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@DomainObject
@Builder
@Getter
public class Order {

    public record OrderVoId(UUID id) {
    }

    public Order(OrderVoId id) {
        this.id = id;
    }

    private final OrderVoId id;

    EnumStatusOrder status;

    List<Item> items;

    public Order() {
        id = new OrderVoId(UUID.randomUUID());
        status = EnumStatusOrder.CREATED;
    }

    public Order(List<Item> items) {
        id = new OrderVoId(UUID.randomUUID());
        status = EnumStatusOrder.CREATED;
        this.items = items;
    }

    public Order(OrderVoId id, List<Item> items) {
        this.id = id;
        status = EnumStatusOrder.CREATED;
        this.items = items;
    }

    public Order(OrderVoId id, EnumStatusOrder status, List<Item> items) {
        this.id = id;
        this.status = status;
        this.items = items;
    }



    public void collect() throws OrderNotReadyException {
        if (status != EnumStatusOrder.READY_TO_COLLECT) {
            throw new OrderNotReadyException(this);
        }
        this.status = EnumStatusOrder.IN_TRANSIT;
    }



    public void startPreparation() throws OrderNotAcceptedException {
        if (status != EnumStatusOrder.ACCEPTED) {
            throw new OrderNotAcceptedException(this);
        }
        this.status = EnumStatusOrder.IN_PREPARATION;
    }


    public void reject() throws ReadyOrderCannotBeRejected {
        if (status == EnumStatusOrder.READY_TO_COLLECT) {
            throw new ReadyOrderCannotBeRejected(this);
        }
        this.status = EnumStatusOrder.REJECTED;
    }

    public void accept() {
        this.status = EnumStatusOrder.ACCEPTED;
    }

    public boolean isCompleted() {

        boolean result = false;

        if (this.status == EnumStatusOrder.READY_TO_COLLECT) {
            result = true;
        } else if (items.stream().allMatch(item -> item.getStatus() == EnumStatusItem.TERMINATED)) {
            this.status = EnumStatusOrder.READY_TO_COLLECT;
            result = true;
        }

        return result;
    }



    public boolean isInTransit() {
        return this.status == EnumStatusOrder.IN_TRANSIT;
    }
}
