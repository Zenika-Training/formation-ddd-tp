package com.zenika.ddd.domain.depot;

import com.zenika.ddd.port.PieceDeposeeRepository;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("LombokGetterMayBeUsed")
public class DepotPieceJustificativeEntity {
    private DepotVoId id;
    private StatutDepot statutDepot = StatutDepot.DEPOSE;
    private LocalDate dateDepot;
    private LocalDate dateExpiration;
    private String referencePieceDeposee;
    private UUID apprenant;
    private UUID formation;
    private DefinitionPieceJustificativeEntity definitionPieceJustificativeEntity;
    private boolean temoinValide;
    private final PieceDeposeeRepository repository;

    public DepotPieceJustificativeEntity(PieceDeposeeRepository repository) {
        this.repository = repository;
    }

    public DepotPieceJustificativeEntity(
            PieceDeposeeRepository repository,
            DepotVoId id,
            StatutDepot statutDepot,
            LocalDate dateDepot,
            LocalDate dateExpiration,
            String referencePieceDeposee,
            UUID apprenant,
            UUID formation,
            DefinitionPieceJustificativeEntity definitionPieceJustificativeEntity,
            boolean temoinValide) {
        this.repository = repository;
        this.id = Objects.requireNonNull(id);
        this.statutDepot = Objects.requireNonNull(statutDepot);
        this.dateDepot = Objects.requireNonNull(dateDepot);
        this.dateExpiration = Objects.requireNonNull(dateExpiration);
        this.referencePieceDeposee = Objects.requireNonNull(referencePieceDeposee);
        this.apprenant = Objects.requireNonNull(apprenant);
        this.formation = Objects.requireNonNull(formation);
        this.definitionPieceJustificativeEntity = Objects.requireNonNull(definitionPieceJustificativeEntity);
        this.temoinValide = temoinValide;
    }

    public DepotVoId getId() {
        return this.id;
    }

    public StatutDepot getStatutDepot() {
        return this.statutDepot;
    }

    public LocalDate getDateDepot() {
        return this.dateDepot;
    }

    public LocalDate getDateExpiration() {
        return this.dateExpiration;
    }

    public String getReferencePieceDeposee() {
        return  this.referencePieceDeposee;
    }

    public UUID getApprenant() {
        return this.apprenant;
    }

    public UUID getFormation() {
        return this.formation;
    }

    public DefinitionPieceJustificativeEntity getDefinitionPieceJustificative() {
        return new DefinitionPieceJustificativeEntity(this.definitionPieceJustificativeEntity);
    }

    public void accepterPieceJustificative() {
        this.statutDepot = StatutDepot.VALIDE;
        repository.enregistrer(this);
    }

    public void refuserPieceJustificative() {
        this.statutDepot = StatutDepot.REJETE;
        repository.enregistrer(this);
    }

    public boolean isTemoinValide() {
        return this.temoinValide;
    }
}

