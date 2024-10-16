package com.zenika.ddd.mvc.controller;

import com.zenika.ddd.mvc.adapter.BonDeCommandeMapper;
import com.zenika.ddd.mvc.dto.BonDeCommande;
import com.zenika.ddd.mvc.dto.BonDeCommandeDTO;
import com.zenika.ddd.stub.NotifierCommandePreteStub;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class NotifierCommandePrete {

    private final NotifierCommandePreteStub notifierCommandePreteStub;
    private final BonDeCommandeMapper bonDeCommandeMapper;

    @PostMapping("/notifier/commande/prete")
    ResponseEntity notifierCommandePrete(@RequestBody
    BonDeCommandeDTO bonDeCommandeDTO) {
        notifierCommandePreteStub.notifierCommandePrete(bonDeCommandeMapper.mapBonDeCommandeDTOToBonDeCommandeEntity(bonDeCommandeDTO));
        return ResponseEntity.ok().build();
    }
}
