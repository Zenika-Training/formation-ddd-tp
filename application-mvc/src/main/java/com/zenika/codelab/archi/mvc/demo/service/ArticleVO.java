package com.zenika.codelab.archi.mvc.demo.service;

import java.math.BigDecimal;

public record ArticleVO(Long id, BigDecimal montant, BigDecimal quantite, String libelle, BigDecimal prixUnite) {
}
