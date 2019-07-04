package com.flight.flightapp.baggage;

import org.springframework.stereotype.Service;

@Service
public class BaggageService {

    private DestinationRepository destinationRepository;
    private BaggageRepository baggageRepository;

    public BaggageService(DummyBaggageRepository baggageRepository, DummyDestinationRepository destinationRepository) {
        this.baggageRepository = baggageRepository;
        this.destinationRepository = destinationRepository;
    }

    public boolean checkIn(String destinationId, String baggageId) {
        if (baggageRepository.find(baggageId).isPresent()
                && destinationRepository.find(destinationId).isPresent()) {
            return true;
        }
        else {
            return false;
        }
    }
}
