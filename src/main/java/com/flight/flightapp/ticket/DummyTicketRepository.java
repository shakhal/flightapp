package com.flight.flightapp.ticket;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DummyTicketRepository implements TicketRepository {

    private Map<String, Ticket> data;

    public DummyTicketRepository() {
        init();
    }

    public Optional<Ticket> find(String ticketId) {
        return Optional.ofNullable(data.get(ticketId));
    }

    private void init() {
        data = new HashMap<>(){{
                put(
                        "111", Ticket.builder().available(true).build()
                );
                put(
                        "222", Ticket.builder().available(true).build()
                );
                put(
                        "333", Ticket.builder().available(true).build()
                );
                put(
                        "444", Ticket.builder().available(false).build()
                );
                put(
                        "555", Ticket.builder().available(false).build()
                );
                put(
                        "666", Ticket.builder().available(false).build()
                );

        }};
    }

}
