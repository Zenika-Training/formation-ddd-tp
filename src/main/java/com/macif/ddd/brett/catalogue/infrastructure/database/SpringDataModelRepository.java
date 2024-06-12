package com.macif.ddd.brett.catalogue.infrastructure.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface SpringDataModelRepository extends CrudRepository<ModeleEntity, UUID> {

    @Override
    List<ModeleEntity> findAll();
}
