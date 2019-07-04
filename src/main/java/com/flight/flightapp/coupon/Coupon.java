package com.flight.flightapp.coupon;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coupon {

    private String id;
    private int discount;

}
