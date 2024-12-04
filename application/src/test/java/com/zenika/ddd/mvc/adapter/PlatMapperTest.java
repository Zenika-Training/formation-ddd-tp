package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.PlatDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PlatMapperTest {

    PlatMapper platMapper = new PlatMapper();

    @Test
    @DisplayName("Should map PlatDto to PlatVO")
    void should_map_PlatDto_to_PlatVO() {
        // Given
        PlatDto platDto = new PlatDto("nom", 10.0);

        // When
        var platVO = platMapper.toPlatVOList(List.of(platDto));

        // Then
        assertFalse(platVO.isEmpty());
        assertThat(platVO.get(0)).extracting(
                    "nom",
                    "prix")
                    .containsExactly(
                            "nom",
                            10.0
                    );
    }
}
