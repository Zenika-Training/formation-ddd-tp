package com.brett.catalog.domain;

import java.util.List;

public interface ReferenceRepository {

    void add(Reference reference);

    Reference get(Code code);

    List<Reference> findAll();
}
