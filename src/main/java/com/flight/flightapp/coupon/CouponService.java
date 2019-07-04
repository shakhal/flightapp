package com.flight.flightapp.coupon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CouponService {

    private CouponRepository couponRepository;

    public CouponService(DummyCouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public CouponCheckResponse getPrice(String couponId, double price) {
        try {
            Optional<Coupon> coupon = couponRepository.find(couponId);

            if (coupon.isPresent()) {
                return CouponCheckResponse.builder()
                        .finalPrice(getFinalPrice(price, coupon.get()))
                        .isValid(true)
                        .build();
            }
            else {
                return CouponCheckResponse.builder()
                        .finalPrice(price)
                        .isValid(false)
                        .build();
            }
        }
        catch (Exception e) {
            log.error("Error applying couponId: {} to price: {}", couponId, price, e);
            throw new CouponCheckException(e);
        }
    }

    private double getFinalPrice(double price, Coupon coupon) {
        return price * discountPercentageOf(coupon);
    }

    private double discountPercentageOf(Coupon coupon) {
        return (1 - (coupon.getDiscount() * 0.01));
    }

    public static class CouponCheckException extends RuntimeException {
        public CouponCheckException(Exception e) {
            super(e);
        }
    }
}
