package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.PlatVO;
import com.zenika.ddd.mvc.dto.PlatDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlatMapper {
    public static List<PlatVO> toPlatVOList(List<PlatDto> plats) {
        List<PlatVO> platVOList = new ArrayList<>();

        plats.forEach(platDto -> {
            PlatVO platVO = PlatVO.builder()
                    .nom(platDto.getNom())
                    .prix(platDto.getPrix())
                    .images(platDto.getImages())
                    .build();
            platVOList.add(platVO);
        });

        return platVOList;
    }
}
