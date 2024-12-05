package com.zenika.codelab.archi.mvc.demo.controler;

import com.zenika.codelab.archi.mvc.demo.service.TicketDTO;
import com.zenika.codelab.archi.mvc.demo.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TicketControler {

    private final TicketService service;

    @GetMapping(value = "/ticket/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<TicketDTO> getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFromId(id));
    }

}
