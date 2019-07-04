package com.flight.flightapp.baggage;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class BaggageCheckRequest {
    private String destinationId;
    private String baggageId;
}
