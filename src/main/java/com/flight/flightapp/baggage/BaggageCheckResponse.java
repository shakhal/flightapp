package com.flight.flightapp.baggage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaggageCheckResponse {
    private boolean success;
}
