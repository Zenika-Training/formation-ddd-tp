package com.macif.ddd.brett.catalogue.application.configuration;

import com.macif.ddd.brett.catalogue.domain.Catalogue;
import com.macif.ddd.brett.catalogue.infrastructure.database.DatabaseModeleRepository;
import com.macif.ddd.brett.catalogue.infrastructure.database.SpringDataModelRepository;
import com.macif.ddd.brett.catalogue.infrastructure.inmemory.InMemoryModelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DomainConfiguration {

    @Bean
    @Profile("in-memory")
    public Catalogue createInMemoryCatalogue() {
        return new Catalogue(new InMemoryModelRepository());
    }

    @Bean
    @Profile("!in-memory")
    public Catalogue createCatalogue(SpringDataModelRepository springDataModelRepository) {
        return
                new Catalogue(
                        new DatabaseModeleRepository(
                                springDataModelRepository));
    }

}
