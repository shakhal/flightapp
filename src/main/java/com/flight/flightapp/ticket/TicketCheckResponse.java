package com.flight.flightapp.ticket;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketCheckResponse {
    private boolean isAvailable;
}
