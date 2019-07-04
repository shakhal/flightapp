package com.flight.flightapp.coupon;

import com.flight.flightapp.cache.ExpiringCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/coupon")
public class CouponController {

    public static final int TTL_SEC = 10;
    private CouponService couponService;
    private ExpiringCache<CouponCheckRequest, CouponCheckResponse> cache = new ExpiringCache<>();

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/check")
    public ResponseEntity isTicketAvailable(@RequestBody CouponCheckRequest couponCheckRequest) {
        if (cache.contains(couponCheckRequest)) {
            log.info("Cache hit");
            return ResponseEntity.ok(cache.get(couponCheckRequest));
        }
        else {
            log.info("Cache miss");
            CouponCheckResponse response = couponService.getPrice(couponCheckRequest.getCouponId(), couponCheckRequest.getPrice());
            cache.add(couponCheckRequest, response, TTL_SEC);
            return ResponseEntity.ok(response);
        }
    }
}
