package com.flight.flightapp.ticket;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket {

    private String id;
    private boolean available;

}
