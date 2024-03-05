package com.zenika.ddd.subdomainrestaurant;

import lombok.Builder;

@Builder
public class Item {

    private String name;
    private Double price;
    private long preparationTimeInMinutes = 10;
    private EnumStatusItem status = EnumStatusItem.CREATED;

    public void startPreparation() {
        this.status = EnumStatusItem.IN_PREPARATION;
    }

    public void finishPreparation() {
        if (this.status != EnumStatusItem.IN_PREPARATION) {
            System.out.println("Item cannot be finished if not in preparation");
        }
        this.status = EnumStatusItem.TERMINATED;
    }

    public EnumStatusItem getStatus() {
        return EnumStatusItem.valueOf(status.name());
    }
}
