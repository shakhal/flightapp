package com.flight.flightapp.coupon;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponCheckResponse {
    private boolean isValid;
    private double finalPrice;
}
