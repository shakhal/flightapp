package com.flight.flightapp.baggage;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
class DummyBaggageRepository implements BaggageRepository {

    private Map<String, Baggage> data;

    public DummyBaggageRepository() {
        init();
    }

    public Optional<Baggage> find(String baggageId) {
        return Optional.ofNullable(data.get(baggageId));
    }

    private void init() {
        data = new HashMap<>(){{
                put(
                        "b1", Baggage.builder().id("11").build()
                );
                put(
                        "b2", Baggage.builder().id("12").build()
                );
                put(
                        "b3", Baggage.builder().id("13").build()
                );
            }};
    }

}
