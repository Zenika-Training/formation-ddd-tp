package com.zenika.ddd.domain.depot;

import com.zenika.ddd.doc.DomainObject;

import java.util.UUID;

@DomainObject
public class DemandePieceJustificativeEntity {

    private UUID uuid;
    private boolean temoinTeleversement = false;
    private boolean temoinDepotPieceObligatoire;
    private String code;
    private IntervalDateVO intervalDateVO;
    private UUID periodeUuid;
    private String formatAccepte;
    private boolean temoinValidationGestionnaire;
    private boolean temoinDateExpiration;
    
    public DemandePieceJustificativeEntity (){
    }

    public DemandePieceJustificativeEntity (
            final UUID uuid,
            boolean temoinTeleversement,
            boolean temoinDepotPieceObligatoire,
            String code,
            IntervalDateVO intervalDateVO,
            UUID periodeUuid,
            String formatAccepte,
            boolean temoinValidationGestionnaire,
            boolean temoinDateExpiration
    ) {
        this.uuid = uuid;
        this.temoinTeleversement = temoinTeleversement;
        this.temoinDepotPieceObligatoire = temoinDepotPieceObligatoire;
        this.code = code;
        this.intervalDateVO = intervalDateVO;
        this.periodeUuid = periodeUuid;
        this.formatAccepte = formatAccepte;
        this.temoinValidationGestionnaire = temoinValidationGestionnaire;
        this.temoinDateExpiration = temoinDateExpiration;

    }


    public UUID getUuid() {
        return uuid;
    }

    public boolean isTeleverse() {
        return temoinTeleversement;
    }

    public boolean televersementEffectue() {
        return this.temoinTeleversement = true;
    }

    public boolean televersementNonEffectue() {
        return this.temoinTeleversement = false;
    }

    public boolean isDepotPieceObligatoire() {
        return temoinDepotPieceObligatoire;
    }

    public boolean rendreObligatoireDepotPiece() {
        return this.temoinDepotPieceObligatoire = true;
    }


    public String getCode() {
        return code;
    }

    public IntervalDateVO getIntervalDateVO() {
        return intervalDateVO;
    }

    public UUID getPeriodeUuid() {
        return periodeUuid;
    }

    public String getFormatAccepte() {
        return formatAccepte;
    }

    public boolean isValideGestionnaire() {
        return temoinValidationGestionnaire;
    }

    public boolean validationGestionnaire() {
        return this.temoinValidationGestionnaire = true;
    }

    public boolean invalidationGestionnaire() {
        return this.temoinValidationGestionnaire = false;
    }

    public boolean isDateExpiree() {
        return temoinDateExpiration;
    }

    public boolean dateExpiree() {
        return this.temoinDateExpiration = true;
    }

    public boolean dateNonExpiree() {
        return this.temoinDateExpiration = false;
    }

}
