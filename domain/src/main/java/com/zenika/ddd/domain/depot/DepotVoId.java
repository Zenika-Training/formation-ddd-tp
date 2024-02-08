package com.zenika.ddd.domain.depot;

import com.zenika.ddd.doc.ValueObject;

import java.util.UUID;

@ValueObject
public record DepotVoId(UUID id) {}
