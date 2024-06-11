package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.ProduitVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ProduitMapperTest {

    ProduitMapper produitMapper = new ProduitMapper();

    @Test
    @DisplayName("Should map PlatDto to PlatVO")
    void should_map_PlatDto_to_PlatVO() {
        // Given
        ProduitVO produitVO = ProduitVO.builder()
                                 .nom("nom")
                                 .prix(10.0)
                                 .build();

        // When
        var platVO = produitMapper.toItemVOList(List.of(produitVO));

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
