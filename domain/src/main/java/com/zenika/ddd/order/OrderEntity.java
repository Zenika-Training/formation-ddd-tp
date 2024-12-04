package com.zenika.ddd.order;

import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@DomainObject
public class OrderEntity {

    private UUID id;
    private CustomerEntity customerEntity;
    private DeliveryManEntity deliveryManEntity;
    private LocalDateTime dateCommande;
    private OrderStatus status;
    private List<ItemVO> itemVOList;

    public OrderEntity(UUID id, CustomerEntity customerEntity, DeliveryManEntity deliveryManEntity, LocalDateTime dateCommande, OrderStatus status, List<ItemVO> itemVOList) {
        this.id = id;
        this.customerEntity = customerEntity;
        this.deliveryManEntity = deliveryManEntity;
        this.dateCommande = dateCommande;
        this.status = Objects.requireNonNullElse(status, OrderStatus.AVAILABLE);
        this.itemVOList = itemVOList;
    }

    public void accept(DeliveryManEntity deliveryMan) {
        this.status = OrderStatus.ACCEPTED;
        this.deliveryManEntity = deliveryMan;
    }

    public static OrderEntityBuilder builder() {
        return new OrderEntity.OrderEntityBuilder();
    }

    public static class OrderEntityBuilder {

        private UUID id;
        private CustomerEntity customerEntity;
        private DeliveryManEntity deliveryManEntity;
        private LocalDateTime dateCommande;
        private OrderStatus status;
        private List<ItemVO> itemVOList;
        public OrderEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public OrderEntityBuilder customerEntity(CustomerEntity customerEntity) {
            this.customerEntity = customerEntity;
            return this;
        }

        public OrderEntityBuilder deliveryManEntity(DeliveryManEntity deliveryManEntity) {
            this.deliveryManEntity = deliveryManEntity;
            return this;
        }

        public OrderEntityBuilder dateCommande(LocalDateTime dateCommande) {
            this.dateCommande = dateCommande;
            return this;
        }

        public OrderEntityBuilder status(OrderStatus status) {
            this.status = status;
            return this;
        }

        public OrderEntityBuilder itemVOList(List<ItemVO> itemVOList) {
            this.itemVOList = itemVOList;
            return this;
        }

        public OrderEntity build() {
            return new OrderEntity(
                    this.id,
                    this.customerEntity,
                    this.deliveryManEntity,
                    this.dateCommande,
                    this.status,
                    this.itemVOList
            );
        }

    }

    public UUID getId() {
        return this.id;
    }

    public DeliveryManEntity getDeliveryManEntity() {
        return this.deliveryManEntity;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public CustomerEntity getCustomerEntity() {
        return this.customerEntity;
    }
}
