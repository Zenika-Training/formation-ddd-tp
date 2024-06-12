package com.macif.ddd.brett.catalogue.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CatalogueServiceTest {

    @Autowired
    private CatalogueService catalogueService;

    @Test
    public void cataloguServiceDoitRetournerDesModeles() {
        var modeles = catalogueService.listerModeles();

        assertThat(modeles).hasSize(1);
    }

}