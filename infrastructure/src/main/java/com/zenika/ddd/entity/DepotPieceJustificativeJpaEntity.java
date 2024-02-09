package com.zenika.ddd.entity;


import com.zenika.ddd.adapter.mapper.StatutDepot;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "depot_piece_justificative")
public class DepotPieceJustificativeJpaEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private StatutDepot statutDepot;

    @Column(name = "date_depot")
    private LocalDate dateDepot;
    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Column(name = "apprenant_uuid")
    private UUID apprenant;

    @ManyToOne
    private DefinitionPieceJustificativeJpaEntity definitionPieceJustificativeEntity;

}
