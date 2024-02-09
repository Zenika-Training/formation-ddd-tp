package com.zenika.ddd.application_service;

import com.zenika.ddd.configuration.SpringConfig;
import com.zenika.ddd.domain.RechercherToutesLesPiecesDeposeesDUnApprenantService;
import com.zenika.ddd.domain.depot.DepotPieceJustificativeEntity;
import com.zenika.ddd.domain.depot.StatutDepot;
import com.zenika.ddd.port.PieceDeposeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class ValidationDepotApplicationServiceTest {

    @Autowired
    private PieceDeposeeRepository repositoryStub;

    @Test
    void accepterTousLesDepotsParApprenantEtInscriptionOK() {

        ValidationDepotApplicationService validationDepotApplicationService = new ValidationDepotApplicationService(new RechercherToutesLesPiecesDeposeesDUnApprenantService(repositoryStub));

        List<DepotPieceJustificativeEntity> depotPieceJustificativeEntities = validationDepotApplicationService.accepterTousLesDepotsParApprenantEtInscription(UUID.randomUUID(), UUID.randomUUID());
        depotPieceJustificativeEntities.forEach(depotPieceJustificativeEntity -> assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.VALIDE));
    }

    @Test
    void refuserTousLesDepotsParApprenantEtInscriptionNonOk() {

            ValidationDepotApplicationService validationDepotApplicationService = new ValidationDepotApplicationService(new RechercherToutesLesPiecesDeposeesDUnApprenantService(repositoryStub));

            List<DepotPieceJustificativeEntity> depotPieceJustificativeEntities = validationDepotApplicationService.refuserTousLesDepotsParApprenantEtInscription(UUID.randomUUID(), UUID.randomUUID());
            depotPieceJustificativeEntities.forEach(depotPieceJustificativeEntity -> assertThat(depotPieceJustificativeEntity.getStatutDepot()).isEqualTo(StatutDepot.REJETE));
    }
}
