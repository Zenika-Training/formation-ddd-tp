package com.zenika.ddd.domain.depot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepotPieceJustificativeEntityTest {


    @Test
    void should_always_be_initialised_with_status_DEPOSE() {
        // Given
        DepotPieceJustificativeEntity depotPieceJustificativeEntity = new DepotPieceJustificativeEntity();

        // When

        // Then
        assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.DEPOSE);
    }

    @Test
    void should_have_status_VALIDE_if_validation_succeed() {
        // Given
        DepotPieceJustificativeEntity depotPieceJustificativeEntity = new DepotPieceJustificativeEntity();

        // When
        depotPieceJustificativeEntity.accepterPieceJustificative();

        // Then
        assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.VALIDE);
    }

    @Test
    void should_have_status_REFUSE_if_validation_unsucceed() {
        // Given
        DepotPieceJustificativeEntity depotPieceJustificativeEntity = new DepotPieceJustificativeEntity();

        // When
        depotPieceJustificativeEntity.refuserPieceJustificative();

        // Then
        assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.REJETE);
    }
}
