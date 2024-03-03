package com.brett.catalog.application;

import com.brett.catalog.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddToCatalogServiceTest {

    private ReferenceRepository referenceRepository;
    private AddToCatalogService addToCatalogService;

    @Test
    public void canAddReferenceToCatalog() {
        referenceRepository = new InMemoryReferenceRepository();
        addToCatalogService = new AddToCatalogService(referenceRepository);

        var code = Code.generate();
        addToCatalogService.addToCatalog(
                code,
                "name",
                "description",
                PricePerDay.of(AmountInCents.of(10000)),
                Map.of("color", "red"));

        var reference = referenceRepository.get(code);
        assertNotNull(reference);
        assertEquals("name", reference.getName());
    }
}