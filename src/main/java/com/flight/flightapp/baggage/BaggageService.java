package com.flight.flightapp.baggage;

import org.springframework.stereotype.Service;

@Service
public class BaggageService {

    private BaggageRepository baggageRepository;

    public BaggageService(DummyBaggageRepository baggageRepository) {
        this.baggageRepository = baggageRepository;
    }

    public boolean checkIn(String destinationId, String baggageId) {
        if (baggageRepository.find(baggageId).isPresent()) {
            return true;
        }
        return false;
    }
}
