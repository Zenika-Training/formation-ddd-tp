package com.brett.catalog.application;

import com.brett.catalog.domain.Fixtures;
import com.brett.catalog.domain.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShowAllReferencesServiceTest {

    @Autowired
    private ShowAllReferencesService showAllReferencesService;
    @Autowired
    private ReferenceRepository referenceRepository;

    public void canShowAllReferences() {
        var vanRyselRef = Fixtures.vanRyselReference();
        var ultra900CF = Fixtures.ultra900CF();
        referenceRepository.add(vanRyselRef);
        referenceRepository.add(ultra900CF);
        var references = showAllReferencesService.showAllReferences();
        assertNotNull(references);
        assertTrue(references.size() >= 2);
    }

}