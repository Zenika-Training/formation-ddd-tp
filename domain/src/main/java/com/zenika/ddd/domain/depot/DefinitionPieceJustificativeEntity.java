package com.zenika.ddd.domain.depot;

import com.zenika.ddd.doc.DomainObject;

import java.util.UUID;

@DomainObject
public class DefinitionPieceJustificativeEntity {

    private UUID uuid;
    private String libellePiece;
    private String descriptif;
    private String typologie;
    private boolean temoinReutilisable;
    private boolean temoinSensible;
    private boolean temoinPhoto;

    public DefinitionPieceJustificativeEntity(){
    }

    public DefinitionPieceJustificativeEntity(final UUID uuid, final String libellePiece, final String descriptif, final String typologie, final boolean temoinReutilisable, final boolean temoinSensible, final boolean temoinPhoto) {
        this.uuid = uuid;
        this.libellePiece = libellePiece;
        this.descriptif = descriptif;
        this.typologie = typologie;
        this.temoinReutilisable = temoinReutilisable;
        this.temoinSensible = temoinSensible;
        this.temoinPhoto = temoinPhoto;
    }

    public DefinitionPieceJustificativeEntity(DefinitionPieceJustificativeEntity definition) {
        this(
                definition.uuid,
                definition.libellePiece,
                definition.descriptif,
                definition.typologie,
                definition.temoinReutilisable,
                definition.temoinSensible,
                definition.temoinPhoto
        );
    }

    public UUID getId() {
        return this.uuid;
    }

    public String getLibellePiece() {
        return libellePiece;
    }


    public String getDescriptif() {
        return descriptif;
    }


    public String getTypologie() {
        return typologie;
    }


    public boolean isTemoinReutilisable() {
        return temoinReutilisable;
    }

    public boolean isTemoinSensible() {
        return temoinSensible;
    }

    public boolean isTemoinPhoto() {
        return temoinPhoto;
    }

}
