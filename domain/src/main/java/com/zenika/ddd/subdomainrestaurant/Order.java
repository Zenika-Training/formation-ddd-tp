package com.zenika.ddd.subdomainrestaurant;

import com.zenika.ddd.doc.DomainObject;

import java.util.List;
import java.util.UUID;

@DomainObject
public class Order {

    EnumStatusOrder status;

    List<Item> items;

    private UUID id;


    public Order(List<Item> items) {
        id = UUID.randomUUID();
        status = EnumStatusOrder.CREATED;
        this.items = items;
    }

    public Order(UUID id, List<Item> items) {
        this.id = id;
        status = EnumStatusOrder.CREATED;
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
