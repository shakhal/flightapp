package com.flight.flightapp.coupon;

import java.util.Optional;

public interface CouponRepository {

    Optional<Coupon> find(String ticketId);
}
