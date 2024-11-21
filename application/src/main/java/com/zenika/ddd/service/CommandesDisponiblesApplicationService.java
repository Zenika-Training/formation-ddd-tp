package com.zenika.ddd.service;

import com.zenika.ddd.mvc.adapter.CommandeDisponiblesMapper;
import com.zenika.ddd.mvc.dto.CommandeDisponibleDto;
import com.zenika.ddd.port.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandesDisponiblesApplicationService {

    private final CommandeDisponiblesMapper commandeDisponiblesMapper;
    private final OrderRepository orderRepository;

    public List<CommandeDisponibleDto> getCommandesDisponibles() {

        return orderRepository.getAll().stream().map(commandeDisponiblesMapper::mapOrderEntityToCommandeDisponibleDto).collect(Collectors.toList());
    }
}
