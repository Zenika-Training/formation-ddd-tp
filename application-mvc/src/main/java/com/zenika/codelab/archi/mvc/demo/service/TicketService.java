package com.zenika.codelab.archi.mvc.demo.service;

import com.zenika.codelab.archi.mvc.demo.repository.TicketEntity;
import com.zenika.codelab.archi.mvc.demo.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    public void save(TicketEntity entity) {
        repository.save(entity);
    }

    public TicketDTO getFromId(Long id) {
        var unTicket = repository.findById(id);
        return Optional.ofNullable(unTicket).map(ticketEntity -> {
            var t = unTicket.get();
            var articles = t.getArticleList().stream().map(articleEntity ->
                    new ArticleVO(articleEntity.getId(), articleEntity.getMontant(), articleEntity.getQuantite(),
                            articleEntity.getLibelle(), articleEntity.getPrixUnite())).toList();

            return new TicketDTO(t.getId(), t.getDateEmission(), articles);

        }).orElse(null);
    }
}
