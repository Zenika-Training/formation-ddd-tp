package com.zenika.ddd.domain.depot;

import com.zenika.ddd.port.PieceDeposeeRepository;
import com.zenika.ddd.stub.DepotPieceJustificativeByApprenantStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepotPieceJustificativeEntityTest {

    PieceDeposeeRepository pieceDeposeeRepository = new DepotPieceJustificativeByApprenantStub();


    @Test
    void should_always_be_initialised_with_status_DEPOSE() {
        // Given
        DepotPieceJustificativeEntity depotPieceJustificativeEntity = new DepotPieceJustificativeEntity(pieceDeposeeRepository);

        // When

        // Then
        assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.DEPOSE);
    }

    @Test
    void should_have_status_VALIDE_if_validation_succeed() {
        // Given
        DepotPieceJustificativeEntity depotPieceJustificativeEntity = new DepotPieceJustificativeEntity(pieceDeposeeRepository);

        // When
        depotPieceJustificativeEntity.accepterPieceJustificative();

        // Then
        assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.VALIDE);
    }

    @Test
    void should_have_status_REFUSE_if_validation_unsucceed() {
        // Given
        DepotPieceJustificativeEntity depotPieceJustificativeEntity = new DepotPieceJustificativeEntity(pieceDeposeeRepository);

        // When
        depotPieceJustificativeEntity.refuserPieceJustificative();

        // Then
        assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.REJETE);
    }
}
