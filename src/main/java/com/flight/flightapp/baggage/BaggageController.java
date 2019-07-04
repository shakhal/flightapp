package com.flight.flightapp.baggage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/baggage")
public class BaggageController {

    //NO CACHE HERE, SORRY :)

    private BaggageService baggageService;

    public BaggageController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @PostMapping("/check")
    public ResponseEntity checkingBaggage(@RequestBody BaggageCheckRequest baggageCheckRequest) {
        return ResponseEntity.ok(BaggageCheckResponse.builder().success(
                baggageService.checkIn(baggageCheckRequest.getDestinationId(), baggageCheckRequest.getBaggageId())
        ).build());
    }
}
