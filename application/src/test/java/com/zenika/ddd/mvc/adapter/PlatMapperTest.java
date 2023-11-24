package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.PlatDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlatMapperTest {

    PlatMapper platMapper = new PlatMapper();

    @Test
    @DisplayName("Should map PlatDto to PlatVO")
    void should_map_PlatDto_to_PlatVO() {
        // Given
        PlatDto platDto = PlatDto.builder()
                .nom("nom")
                .prix(10.0)
                .build();

        // When
        var platVO = platMapper.toPlatVOList(List.of(platDto));

        // Then
        platVO.stream().forEach(platVO1 -> {
            assertThat(platVO1).extracting(
                    "nom",
                    "prix")
                    .containsExactly(
                            "nom",
                            10.0
                    );
        });
    }
}
