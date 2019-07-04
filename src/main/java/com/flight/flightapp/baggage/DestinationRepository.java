package com.flight.flightapp.baggage;

import java.util.Optional;

public interface DestinationRepository {
    Optional<Destination> find(String destinationId);
}
