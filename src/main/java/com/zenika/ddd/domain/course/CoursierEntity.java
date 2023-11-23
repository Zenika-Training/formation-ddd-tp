package com.zenika.ddd.domain.course;

import com.zenika.ddd.domain.shared.Adresse;
import com.zenika.ddd.domain.shared.Position;

import java.util.UUID;

public class CoursierEntity {
    private UUID id;
    private Position position;
    private Adresse adresse;
}
