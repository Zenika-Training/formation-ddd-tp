package com.brett.catalog.application;

import com.brett.ApplicationService;
import com.brett.catalog.domain.catalog.Catalogue;
import com.brett.catalog.domain.catalog.VeloAndPrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationService
@Service
public class GetModelesAndPrixFromCatalog {

    @Autowired
    Catalogue catalogue;

    // Authorization
    @Transactional
    public List<VeloAndPrix> getVelosAndPrix() {
        return catalogue.getVelosCatalogue();
    }

}
