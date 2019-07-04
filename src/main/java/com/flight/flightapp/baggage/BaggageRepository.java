package com.flight.flightapp.baggage;

import java.util.Optional;

public interface BaggageRepository {
    Optional<Baggage> find(String baggageId);
}
