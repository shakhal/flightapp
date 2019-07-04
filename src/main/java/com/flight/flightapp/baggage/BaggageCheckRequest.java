package com.flight.flightapp.baggage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaggageCheckRequest {
    private String destinationId;
    private String baggageId;
}
