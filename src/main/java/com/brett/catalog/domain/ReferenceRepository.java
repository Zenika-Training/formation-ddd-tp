package com.brett.catalog.domain;

public interface ReferenceRepository {

    void add(Reference reference);

    Reference get(Code code);
}
