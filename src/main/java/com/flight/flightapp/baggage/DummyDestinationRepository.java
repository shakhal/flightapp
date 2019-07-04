package com.flight.flightapp.baggage;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
class DummyDestinationRepository implements DestinationRepository {

    private Map<String, Destination> data;

    public DummyDestinationRepository() {
        init();
    }

    public Optional<Destination> find(String destinationId) {
        return Optional.ofNullable(data.get(destinationId));
    }

    private void init() {
        data = new HashMap<>(){{
                put(
                        "d1", Destination.builder().id("11").build()
                );
                put(
                        "d2", Destination.builder().id("12").build()
                );
                put(
                        "d3", Destination.builder().id("13").build()
                );
            }};
    }

}
