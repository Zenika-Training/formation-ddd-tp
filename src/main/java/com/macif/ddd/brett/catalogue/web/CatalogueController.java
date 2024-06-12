package com.macif.ddd.brett.catalogue.web;

import com.macif.ddd.brett.catalogue.application.CatalogueService;
import com.macif.ddd.brett.catalogue.domain.model.Modele;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogueController {

    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping("/modele")
    public List<Modele> listerModeles() {
        return catalogueService.listerModeles();
    }
}
