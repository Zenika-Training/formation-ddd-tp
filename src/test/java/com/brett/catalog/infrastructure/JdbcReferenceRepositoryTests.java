package com.brett.catalog.infrastructure;

import com.brett.catalog.domain.Fixtures;
import com.brett.catalog.domain.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcReferenceRepositoryTests {

    @Autowired
    private JdbcReferenceRepository jdbcReferenceRepository;

    @Test
    public void canAddReference() {
        var vanRyselRef = Fixtures.vanRyselReference();
        jdbcReferenceRepository.add(vanRyselRef);
        var savedRef = jdbcReferenceRepository.get(vanRyselRef.getCode());
        assertNotNull(savedRef);
        assertEquals(vanRyselRef.getCode(), savedRef.getCode());
        assertEquals(vanRyselRef.getName(), savedRef.getName());
        assertEquals(vanRyselRef.getDescription(), savedRef.getDescription());
        assertEquals(vanRyselRef.getPricePerDay(), savedRef.getPricePerDay());

        vanRyselRef.getCharacteristics().forEach((key, value) -> {
            assertEquals(value, savedRef.getCharacteristics().get(key));
        });

        vanRyselRef.addCharacteristic("test", "test");
    }

    @Test
    public void canFindAllReferences() {
        var vanRyselRef = Fixtures.vanRyselReference();
        var ultra900CF = Fixtures.ultra900CF();
        jdbcReferenceRepository.add(vanRyselRef);
        jdbcReferenceRepository.add(ultra900CF);
        var savedRefs = jdbcReferenceRepository.findAll();
        assertNotNull(savedRefs);
        assertTrue(savedRefs.size() >= 2);
    }
}