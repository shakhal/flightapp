package com.flight.flightapp.ticket;

import com.flight.flightapp.cache.ExpiringCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/tickets")
public class TicketController {

    public static final int TTL_SEC = 10;
    private TicketService ticketService;

    private ExpiringCache<String, TicketCheckResponse> cache = new ExpiringCache<>();

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{ticketId}/available")
    public ResponseEntity isTicketAvailable(@PathVariable String ticketId) {
        if (cache.contains(ticketId)) {
            log.info("Cache hit");
            return ResponseEntity.ok(cache.get(ticketId));
        }
        else {
            log.info("Cache miss");
            boolean isAvailable = ticketService.isAvailable(ticketId);
            TicketCheckResponse response = TicketCheckResponse.builder().isAvailable(isAvailable).build();
            cache.add(ticketId, response, TTL_SEC);
            return ResponseEntity.ok(response);
        }
    }
}
