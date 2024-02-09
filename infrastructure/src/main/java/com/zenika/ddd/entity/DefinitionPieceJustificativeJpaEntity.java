package com.zenika.ddd.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "definition_piece_justificative")
@Data
public class DefinitionPieceJustificativeJpaEntity {

    @Id
    private String id;

    @Column(name = "libelle_piece")
    private String libellePiece;

    @Column(name = "descriptif")
    private String descriptif;

    @Column(name = "typologie")
    private String typologie;

    @Column(name = "temoin_reutilisable")
    private boolean temoinReutilisable;

    @Column(name = "temoin_sensible")
    private boolean temoinSensible;

    @Column(name = "temoin_photo")
    private boolean temoinPhoto;
}
