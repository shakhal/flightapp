package com.flight.flightapp.ticket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(DummyTicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean isAvailable(String ticketId) {
        try {
            log.debug("Checking for ticket availability: {}", ticketId);
            Optional<Ticket> ticket = ticketRepository.find(ticketId);
            if (ticket.isPresent()) {
                boolean isAvailable = ticket.get().isAvailable();
                log.debug("ticket availability: {} is {}", ticketId, isAvailable);
                return isAvailable;
            }
            else {
                log.error("Ticket not found {}", ticketId);
                return false;
            }
        }
        catch (Exception e) {
            log.error("Error checking ticket by id:" + ticketId, e);
            return false;
        }
    }

}
