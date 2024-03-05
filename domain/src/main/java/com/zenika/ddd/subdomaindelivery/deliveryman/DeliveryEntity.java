package com.zenika.ddd.subdomaindelivery.deliveryman;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.StatutCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DomainObject
public class DeliveryEntity {
    @Builder.Default
    private final UUID id = UUID.randomUUID();
    private UUID commandeId;
    private DeliveryManEntity deliveryManEntity;
    @Builder.Default
    private StatutCourse statut = StatutCourse.ACCEPTED;
    private Destination destination;
    private RestaurantEntity restaurant;
}
