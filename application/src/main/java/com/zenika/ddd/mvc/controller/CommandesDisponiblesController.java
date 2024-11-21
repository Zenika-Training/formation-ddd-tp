package com.zenika.ddd.mvc.controller;

import com.zenika.ddd.mvc.dto.CommandeDisponibleDto;
import com.zenika.ddd.service.CommandesDisponiblesApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommandesDisponiblesController {

    private final CommandesDisponiblesApplicationService commandesDisponiblesApplicationService;

    @RequestMapping(value = "/commandes-disponibles",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public @ResponseBody List<CommandeDisponibleDto> getCommandesDisponibles() {
        return commandesDisponiblesApplicationService.getCommandesDisponibles();
    }
}
