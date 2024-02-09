CREATE TABLE definition_piece_justificative(id INT PRIMARY KEY ,
                                            libelle_piece VARCHAR(255),
                                            descriptif VARCHAR(255),
                                            typologie VARCHAR(255),
                                            temoin_reutilisable BOOLEAN,
                                            temoin_sensible BOOLEAN,
                                            temoin_photo BOOLEAN);

CREATE TABLE depot_piece_justificative(id INT PRIMARY KEY ,
                                       statut_depot VARCHAR(255),
                                       date_depot DATE,
                                       date_expiration DATE,
                                       apprenant_uuid INT,
                                       DEFINITION_PIECE_JUSTIFICATIVE_ENTITY_ID INT
);

INSERT INTO definition_piece_justificative (id,
                                            libelle_piece,
                                            descriptif,
                                            typologie,
                                            temoin_reutilisable,
                                            temoin_sensible,
                                            temoin_photo)
VALUES ('7e3dbb9c-08ec-4c77-bcd3-8b816a1f0a71',
        'CNI',
        'Pièce identite',
        'Carte Nationnale Identite',
        true,
        false,
        true);

INSERT INTO depot_piece_justificative (id,
                                        statut_depot,
                                        date_depot,
                                        date_expiration,
                                        apprenant_uuid,
                                       DEFINITION_PIECE_JUSTIFICATIVE_ENTITY_ID
                                       )
VALUES ('f0a2380e-7b1d-4efb-9c43-2d6e384b3fe1',
        'DEPOSE',
        '2024-02-09',
        '2025-02-09',
        '9c63b2c7-aa55-4a18-8c2f-1f7e87a9d58a',
        '7e3dbb9c-08ec-4c77-bcd3-8b816a1f0a71'
        );

INSERT INTO depot_piece_justificative (id,
                                       statut_Depot,
                                       date_Depot,
                                       date_expiration,
                                       apprenant_uuid,
                                       DEFINITION_PIECE_JUSTIFICATIVE_ENTITY_ID)
VALUES ('6f5725a0-1a94-4a53-aa72-cd984c545c33',
        'DEPOSE',
        '2024-02-01',
        '2025-02-01',
        '9c63b2c7-aa55-4a18-8c2f-1f7e87a9d58a',
        '7e3dbb9c-08ec-4c77-bcd3-8b816a1f0a71'
       );
