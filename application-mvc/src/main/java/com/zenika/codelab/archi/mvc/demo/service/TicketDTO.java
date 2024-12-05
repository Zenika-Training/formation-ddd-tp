package com.zenika.codelab.archi.mvc.demo.service;

import java.time.LocalDate;
import java.util.List;

public record TicketDTO(Long id, LocalDate dateEmission, List<ArticleVO> articles) {

}
