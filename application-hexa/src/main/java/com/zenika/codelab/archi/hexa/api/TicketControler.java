package com.zenika.codelab.archi.hexa.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TicketControler {


    @GetMapping(value = "/ticket/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getTicket(@PathVariable Long id) {
        return null;
    }

}
