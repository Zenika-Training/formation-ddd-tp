package com.brett.catalog.application;

import com.brett.catalog.domain.Code;
import com.brett.catalog.domain.PricePerDay;
import com.brett.catalog.domain.Reference;
import com.brett.catalog.domain.ReferenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AddToCatalogService {

    private final ReferenceRepository referenceRepository;

    public AddToCatalogService(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    @Transactional
    public void addToCatalog(Code code, String name, String description, PricePerDay pricePerDay, Map<String, String> characteristics) {
        var ref = Reference.make(code, name, description, pricePerDay, characteristics);
        referenceRepository.add(ref);
    }

}
