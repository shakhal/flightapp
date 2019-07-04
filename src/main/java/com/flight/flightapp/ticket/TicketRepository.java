package com.flight.flightapp.ticket;

import java.util.Optional;

public interface TicketRepository {

    Optional<Ticket> find(String ticketId);
}
