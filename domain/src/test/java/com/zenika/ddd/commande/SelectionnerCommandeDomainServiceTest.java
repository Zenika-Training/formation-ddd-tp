package com.zenika.ddd.commande;

import com.zenika.ddd.commande.stub.CommandeEmptyRepositoryStub;
import com.zenika.ddd.commande.stub.CommandeExistingOrderRepositoryStub;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SelectionnerCommandeDomainServiceTest {

    SelectionnerCommandeDomainService selectionnerCommandeDomainService;

    @Test
    @Description("Should pass if the order doesn't exist")
    void should_pass_if_we_try_to_add_a_new_order() {
        //Given
        selectionnerCommandeDomainService = new SelectionnerCommandeDomainService(new CommandeEmptyRepositoryStub());
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .itemVOList(List.of(ItemVO.builder()
                        .nom("toto")
                        .prix(1)
                        .build()
                ))
                .build();

        // When / then
        OrderEntity orderEntity1 = selectionnerCommandeDomainService.ajouterCommande(orderEntity);
    }

    @Test
    @Description("Should raise an IllegalArgumentException if the order already exists")
    void should_raise_an_IllegalArgumentException_if_we_try_to_add_an_existing_order() {
        //Given
        selectionnerCommandeDomainService = new SelectionnerCommandeDomainService(new CommandeExistingOrderRepositoryStub());
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .itemVOList(List.of(ItemVO.builder()
                        .nom("toto")
                        .prix(1)
                        .build()
                ))
                .build();

        // When / then
        assertThrows(IllegalArgumentException.class, () -> selectionnerCommandeDomainService.ajouterCommande(orderEntity));
    }

}
