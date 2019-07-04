package com.flight.flightapp.baggage;

import com.flight.flightapp.ticket.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/baggage")
public class BaggageController {

    private TicketService ticketService;

    public BaggageController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @PostMapping("/{baggageId}/destination/{destinatioId}")
//    public ResponseEntity checkingBaggage(@PathVariable String baggageId, @PathVariable String destinationId) {
////        return ResponseEntity.ok(ticketService.isAvailable(ticketId));
//    }
}
