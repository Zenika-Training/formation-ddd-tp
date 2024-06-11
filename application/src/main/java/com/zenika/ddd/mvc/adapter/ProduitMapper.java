package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.ItemVO;
import com.zenika.ddd.mvc.dto.ProduitVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduitMapper {
    public static List<ItemVO> toItemVOList(List<ProduitVO> plats) {
        List<ItemVO> itemVOList = new ArrayList<>();

        if (plats == null) {
            return itemVOList;
        }

        plats.forEach(produitVO -> {
            ItemVO itemVO = ItemVO.builder()
                                  .nom(produitVO.getNom())
                                  .prix(produitVO.getPrix())
                                  .images(produitVO.getImages())
                                  .build();
            itemVOList.add(itemVO);
        });

        return itemVOList;
    }

    public List<ProduitVO> toProduitVOList(List<ItemVO> itemVOList) {
        List<ProduitVO> plats = new ArrayList<>();

        itemVOList.forEach(itemVO -> {
            ProduitVO produitVO = ProduitVO.builder()
                                           .nom(itemVO.nom())
                                           .prix(itemVO.prix())
                                           .images(itemVO.images())
                                           .build();
            plats.add(produitVO);
        });

        return plats;
    }
}
