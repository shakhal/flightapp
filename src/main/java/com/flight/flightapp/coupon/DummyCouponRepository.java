package com.flight.flightapp.coupon;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
class DummyCouponRepository implements CouponRepository {

    private Map<String, Coupon> data;

    public DummyCouponRepository() {
        init();
    }

    public Optional<Coupon> find(String ticketId) {
        return Optional.ofNullable(data.get(ticketId));
    }

    private void init() {
        data = new HashMap<>(){{
                put(
                        "11", Coupon.builder().id("11").discount(10).build()
                );
                put(
                        "12", Coupon.builder().id("12").discount(50).build()
                );
                put(
                        "13", Coupon.builder().id("13").discount(60).build()
                );
            }};
    }

}
