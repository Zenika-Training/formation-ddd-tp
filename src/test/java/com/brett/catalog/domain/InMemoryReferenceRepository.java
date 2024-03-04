package com.brett.catalog.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryReferenceRepository implements ReferenceRepository {
    Map<Code, Reference> references = new HashMap<>();

    @Override
    public void add(Reference reference) {
        references.put(reference.getCode(), reference);
    }

    @Override
    public Reference get(Code code) {
        return references.get(code);
    }

    @Override
    public List<Reference> findAll() {
        return references.values().stream().toList();
    }
}
